package com.example.mymovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymovie.R;
import com.example.mymovie.model.model;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    RequestOptions option;
    Context mContext;
//    List<model> mData;
    ArrayList<model>arrayList;
    public RecyclerViewAdapter(Context mContext,ArrayList<model>arrayList){
        this.mContext = mContext;
        this.arrayList = arrayList;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.frown).error(R.drawable.frown);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_movie_nowplaying,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.productname.setText(arrayList.get(position).getTitle());
        Glide.with(mContext).load(url+arrayList.get(position).getImage()).apply(option).into(holder.imageproduct);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView productname;
        ImageView imageproduct;

        public MyViewHolder(View itemview){
            super(itemview);
            productname = (TextView)itemview.findViewById(R.id.productName_nowplaying);
            imageproduct = (ImageView)itemview.findViewById(R.id.productImg_nowplaying);

itemview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});

        }
    }
}
