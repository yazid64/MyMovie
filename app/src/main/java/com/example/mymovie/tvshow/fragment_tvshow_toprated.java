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
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.mymovie.R;
import com.example.mymovie.Tvmodel.Adapter_popular;
import com.example.mymovie.Tvmodel.Adapter_toprated;
import com.example.mymovie.model.Tvshow;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_tvshow_toprated extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private Adapter_toprated recyclerViewAdapter;
    SwipeRefreshLayout swipeLayout;
    ArrayList<Tvshow> arrayList = new ArrayList<>();
    public fragment_tvshow_toprated(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_fragment_tvshow_toprated,container,false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rv_tv_toprated);
        swipeLayout =v.findViewById(R.id.swipe_tv_toprated);
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
        recyclerViewAdapter = new Adapter_toprated(getContext(),arrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    private void fetchJobs() {
        AndroidNetworking.get("https://api.themoviedb.org/3/tv/top_rated?api_key=c55707e61472f37ee6d234e3d5171e4c&language=en-US&page=1")
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
                            Toast.makeText(getContext(),"Koneksi anda buruk",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("", "onError: " + anError.getErrorBody());

                    }
                });
    }
}
