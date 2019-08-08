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
import com.example.mymovie.model.people;
import com.example.mymovie.people.Detail;

import java.util.List;

public class people_adapter extends RecyclerView.Adapter<people_adapter.JobsViewHolder> {
    Context mCtx;

    //we are storing all the products in a list
    List<people> jobList;
    RequestOptions option;
    //getting the context and product list with constructor
    public people_adapter(Context mCtx, List<people> jobList) {
        this.mCtx = mCtx;
        this.jobList = jobList;
    }

    @Override
    public JobsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_people, parent, false);
        final JobsViewHolder vHolder = new JobsViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final JobsViewHolder holder, final int position) {
        //getting the product of the specified position
        final people job = jobList.get(position);
//        holder.name.setText(job.getShop_name());
//        holder.address.setText(job.getShop_address());
        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.name.setText(job.getName());
        Glide.with(mCtx).load(url+job.getProfile_path()).apply(option).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView img;

        public JobsViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.productName_people);
            img = (ImageView)itemView.findViewById(R.id.productImg_people);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mCtx, Detail.class);
                    i.putExtra("get",jobList.get(getAdapterPosition()));
                    mCtx.startActivity(i);
                }
            });
        }
    }
}

