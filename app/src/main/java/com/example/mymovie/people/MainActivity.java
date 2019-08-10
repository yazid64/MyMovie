package com.example.mymovie.people;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.R;
import com.example.mymovie.adapter.PeopleAdapter;
import com.example.mymovie.model.people;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PeopleAdapter recyclerViewAdapter;
    SwipeRefreshLayout swipeLayout;
    private List<people>peopleList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recy_people);
        swipeLayout = findViewById(R.id.swipe_container);
        fetchJobs();
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code here
                fetchJobs();
                // To keep animation for 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        // Stop animation (This will be after 3 seconds)
                        swipeLayout.setRefreshing(false);
                    }
                }, 3000);
//                Toast.makeText(getApplicationContext(), "Job is Up to date!", Toast.LENGTH_SHORT).show();// Delay in millis
            }
        });
setupRecyclerJobs();
    }

    private void setupRecyclerJobs(){
        recyclerViewAdapter = new PeopleAdapter(this, peopleList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void fetchJobs() {
        AndroidNetworking.get("https://api.themoviedb.org/3/person/popular?api_key=c55707e61472f37ee6d234e3d5171e4c&language=en-US&page=1")
                .setTag("results")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            peopleList.clear();
                            JSONArray nowplaying = response.getJSONArray("results");
                            for (int i = 0; i < nowplaying.length(); i++) {
                                JSONObject hasil = nowplaying.getJSONObject(i);
                                people item = new people();
                                item.setName(hasil.getString("name"));
                                item.setPopularity(hasil.getString("popularity"));
                                item.setProfile_path(hasil.getString("profile_path"));

                                JSONArray jsonArray = hasil.getJSONArray("known_for");
                                for (int j = 0; j < jsonArray.length(); j++) {
                                    Log.e("", "index: " + j);
                                    item.setTitle(jsonArray.getJSONObject(j).optString("title"));
                                    item.setImage_film(jsonArray.getJSONObject(j).optString("poster_path"));
                                    item.setVote_average(jsonArray.getJSONObject(j).optString("vote_average"));
                                    item.setMedia_type(jsonArray.getJSONObject(j).optString("media_type"));
                                    item.setOriginal_language(jsonArray.getJSONObject(j).optString("original_language"));
                                    item.setOriginal_title(jsonArray.getJSONObject(j).optString("original_title"));
                                    item.setPopularity_film(jsonArray.getJSONObject(j).optString("popularity"));
                                    item.setOverview(jsonArray.getJSONObject(j).optString("overview"));
                                    item.setRelease(jsonArray.getJSONObject(j).optString("release_date"));
//                                    String title = ;
                                    Log.d("check response", "onResponse: "+item.getTitle());
                                }

                                peopleList.add(item);

                                Log.e("", "onResponse: " + peopleList.size());
                            }
                            recyclerViewAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("", "onError: " + anError.getErrorBody());
                        Toast.makeText(getApplicationContext(),"Koneksi anda buruk",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
