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
import com.example.mymovie.model.Tvshow;

import java.util.ArrayList;

public class Adapter_ontheair extends RecyclerView.Adapter<Adapter_ontheair.MyViewHolder>{

    RequestOptions option;
    Context mContext;
    //    List<model> mData;
    ArrayList<Tvshow> ontheair;
    public Adapter_ontheair(Context mContext,ArrayList<Tvshow>ontheair){
        this.mContext = mContext;
        this.ontheair = ontheair;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_tv_ontheair,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Tvshow mModel = ontheair.get(position);

        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.productname.setText(mModel.getName());
        Glide.with(mContext).load(url+mModel.getPoster_path()).apply(option).into(holder.imageproduct);

    }

    @Override
    public int getItemCount() {
        return ontheair.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        ImageView imageproduct;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productname = (TextView)itemView.findViewById(R.id.productName_tv_ontheair);
            imageproduct = (ImageView)itemView.findViewById(R.id.productImg_tv_ontheair);

        }
    }
}
