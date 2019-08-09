package com.example.mymovie.movie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.R;
import com.example.mymovie.adapter.RecyclerViewAdapter;
import com.example.mymovie.model.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fragment_movie_nowplaying extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
//    List<model> lstmodel;
    SwipeRefreshLayout swipeLayout;
    ArrayList<model>arrayList = new ArrayList<>();
    public fragment_movie_nowplaying(){
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment_movie_nowplaying,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rv_movie_nowplaying);
        swipeLayout =v.findViewById(R.id.swipe_movie_nowplaying);
        fetchJobs();

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code here
                arrayList.clear();
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
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void fetchJobs() {
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/now_playing?api_key=c55707e61472f37ee6d234e3d5171e4c&language=en-US&page=1")
                .setTag("results")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                                JSONArray nowplaying = response.getJSONArray("results");
                                for (int i = 0; i < nowplaying.length(); i++) {
                                    JSONObject hasil = nowplaying.getJSONObject(i);
                                    model item = new model();
                                    item.setTitle(hasil.getString("title"));
                                    item.setOriginal_language(hasil.getString("original_language"));
                                    item.setOriginal_title(hasil.getString("original_title"));
                                    item.setOverview(hasil.getString("overview"));
                                    item.setPopularity(hasil.getString("popularity"));
                                    item.setRelease_date(hasil.getString("release_date"));
                                    item.setVote_average(hasil.getString("vote_average"));
                                    item.setImage(hasil.getString("poster_path"));
                                    arrayList.add(item);
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
                        Toast.makeText(getContext(),"Koneksi anda buruk",Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
