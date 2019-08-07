package com.example.mymovie.tvshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.R;
import com.example.mymovie.Tvmodel.Adapter_airingtoday;
import com.example.mymovie.adapter.RecyclerViewAdapter;
import com.example.mymovie.model.Tvshow;
import com.example.mymovie.model.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_tvshow_airingtoday extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private Adapter_airingtoday recyclerViewAdapter;
    //    List<model> lstmodel;
    SwipeRefreshLayout swipeLayout;
    ArrayList<Tvshow> arrayList = new ArrayList<>();

    public fragment_tvshow_airingtoday(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment_tvshow_airingtoday,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rv_tv_airingtoday);
        swipeLayout =v.findViewById(R.id.swipe_tv_airingtoday);
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
        recyclerViewAdapter = new Adapter_airingtoday(getContext(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    private void fetchJobs() {
        AndroidNetworking.get("https://api.themoviedb.org/3/tv/airing_today?api_key=c55707e61472f37ee6d234e3d5171e4c&language=en-US&page=1")
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
                                Tvshow item = new Tvshow();
                                item.setName(hasil.getString("name"));
                                item.setFirst_air_date(hasil.getString("first_air_date"));
                                item.setOriginal_language(hasil.getString("original_language"));
                                item.setOverview(hasil.getString("overview"));
                                item.setPoster_path(hasil.getString("poster_path"));
                                item.setPopularity(hasil.getString("popularity"));
                                item.setOrginal_name(hasil.getString("original_name"));
                                item.setVote_average(hasil.getString("vote_average"));
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

                    }
                });
    }
}
