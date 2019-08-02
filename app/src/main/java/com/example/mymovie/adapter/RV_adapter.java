package com.example.mymovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovie.R;
import com.example.mymovie.model.model;

import java.util.List;

public class RV_adapter extends RecyclerView.Adapter<RV_adapter.MyViewHolder> {


    Context context;
    List<model>mData;

    public RV_adapter(Context context, List<model> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RV_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RV_adapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
