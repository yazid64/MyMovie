package com.example.mymovie.Tvmodel;

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
import com.example.mymovie.model.Tvshow;
import com.example.mymovie.tvshow.Detail_airingtoday;
import com.example.mymovie.tvshow.Detail_toprated;

import java.util.ArrayList;

public class Adapter_toprated extends RecyclerView.Adapter<Adapter_toprated.MyViewHolder>{

    RequestOptions option;
    Context mContext;
    //    List<model> mData;
    ArrayList<Tvshow> toprated;
    public Adapter_toprated(Context mContext,ArrayList<Tvshow>toprated){
        this.mContext = mContext;
        this.toprated = toprated;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_tv_toprated,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Tvshow mModel = toprated.get(position);

        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.productname.setText(mModel.getName());
        Glide.with(mContext).load(url+mModel.getPoster_path()).apply(option).into(holder.imageproduct);
    }

    @Override
    public int getItemCount() {
        return toprated.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        ImageView imageproduct;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            productname = (TextView)itemView.findViewById(R.id.productName_tv_toprated);
            imageproduct = (ImageView)itemView.findViewById(R.id.productImg_tv_toprated);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext, Detail_toprated.class);
                    i.putExtra("get",toprated.get(getAdapterPosition()));
                    mContext.startActivity(i);
                }
            });
        }
    }
}
