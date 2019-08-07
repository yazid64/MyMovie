package com.example.mymovie.people;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.R;
import com.example.mymovie.adapter.RecyclerViewAdapter;
import com.example.mymovie.model.model;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    //    List<model> lstmodel;
    SwipeRefreshLayout swipeLayout;
    ArrayList<model> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recy_people);
        fetchJobs();
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
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
                            JSONArray nowplaying = response.getJSONArray("results");
                            for (int i = 0; i < nowplaying.length(); i++) {
//                                JSONObject hasil = nowplaying.getJSONObject(i);
//                                model item = new model();
//                                item.setTitle(hasil.getString("title"));
//                                item.setOriginal_language(hasil.getString("original_language"));
//                                item.setOriginal_title(hasil.getString("original_title"));
//                                item.setOverview(hasil.getString("overview"));
//                                item.setPopularity(hasil.getString("popularity"));
//                                item.setRelease_date(hasil.getString("release_date"));
//                                item.setVote_average(hasil.getString("vote_average"));
//                                item.setImage(hasil.getString("poster_path"));
//                                arrayList.add(item);
                                JSONArray jsonArray = nowplaying.getJSONObject(i).getJSONArray("known_for");

                                for (int j = 0; j < jsonArray.length(); j++) {
                                    model model = new model();
                                    model.setTitle(jsonArray.getJSONObject(j).getString("title"));
//                                    String title = ;
                                    Log.d("check response", "onResponse: "+model.getTitle());
                                }

                                Log.e("", "onResponse: " + arrayList.size());
                            }
                            recyclerViewAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("", "onError: " + anError.getErrorBody());

                    }
                });
    }
}
