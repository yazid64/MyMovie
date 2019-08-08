package com.example.mymovie.movie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.MovieModel.Adapter_toprated;
import com.example.mymovie.R;
import com.example.mymovie.model.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_movie_toprated extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private Adapter_toprated recyclerViewAdapter;
    //    List<model> lstmodel;
    SwipeRefreshLayout swipeLayout;
    ArrayList<model> populars = new ArrayList<>();

    public fragment_movie_toprated(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment_movie_toprated,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rv_movie_toprated);
        swipeLayout =v.findViewById(R.id.swipe_movie_toprated);
        fetchJobs();
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code here
                populars.clear();
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
        recyclerViewAdapter = new Adapter_toprated(getContext(),populars);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    private void fetchJobs() {
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/top_rated?api_key=c55707e61472f37ee6d234e3d5171e4c&language=en-US&page=1")
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
                                    populars.add(item);
                                    Log.e("", "onResponse: " + populars.size());
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
