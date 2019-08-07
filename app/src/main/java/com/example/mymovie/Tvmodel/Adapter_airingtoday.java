package com.example.mymovie.Tvmodel;

import android.content.Context;
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
import com.example.mymovie.adapter.RecyclerViewAdapter;
import com.example.mymovie.model.Tvshow;
import com.example.mymovie.model.model;

import java.util.ArrayList;


public class Adapter_airingtoday extends RecyclerView.Adapter<Adapter_airingtoday.MyViewHolder>{

    RequestOptions option;
    Context mContext;
    //    List<model> mData;
    ArrayList<Tvshow> airingtoday;
    public Adapter_airingtoday(Context mContext,ArrayList<Tvshow>airingtoday){
        this.mContext = mContext;
        this.airingtoday = airingtoday;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_tv_airingtoday,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_airingtoday.MyViewHolder holder, int position) {
        final Tvshow mModel = airingtoday.get(position);

        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.productname.setText(mModel.getName());
        Glide.with(mContext).load(url+mModel.getPoster_path()).apply(option).into(holder.imageproduct);
    }

    @Override
    public int getItemCount() {
        return airingtoday.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        ImageView imageproduct;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productname = (TextView)itemView.findViewById(R.id.productName_tv_airingtoday);
            imageproduct = (ImageView)itemView.findViewById(R.id.productImg_tv_airingtoday);
        }
    }
}
