package com.example.mymovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovie.R;
import com.example.mymovie.model.model;
import com.example.mymovie.model.people;
import com.example.mymovie.people.Detail;

import java.util.List;

public class people_adapter extends RecyclerView.Adapter<people_adapter.JobsViewHolder> {
    private Context mCtx;

    //we are storing all the products in a list
    private List<people> jobList;

    //getting the context and product list with constructor
    public people_adapter(Context mCtx, List<people> jobList) {
        this.mCtx = mCtx;
        this.jobList = jobList;
    }

    @Override
    public JobsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_people, parent, false);
        return new JobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final JobsViewHolder holder, final int position) {
        //getting the product of the specified position
        final people job = jobList.get(position);
//        holder.name.setText(job.getShop_name());
//        holder.address.setText(job.getShop_address());
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    class JobsViewHolder extends RecyclerView.ViewHolder {

        TextView name, address;

        JobsViewHolder(View itemView) {
            super(itemView);

//            name = itemView.findViewById(R.id.tv_shop_name);
//            address = itemView.findViewById(R.id.tv_shop_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mCtx, Detail.class);
//                    i.putExtra("extra_job", jobList.get(getAdapterPosition()));
                    mCtx.startActivity(i);

                }
            });
        }
    }
}

