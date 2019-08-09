package com.example.mymovie.adapter;

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
import com.example.mymovie.model.people;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private Context mCtx;
    private List<people> peopleList;
    RequestOptions option;

public PeopleAdapter(Context mCtx,List<people>peopleList){
this.mCtx = mCtx;
this.peopleList = peopleList;

    option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
}

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_people,parent,false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PeopleViewHolder holder,final int position) {

        final people peo =peopleList.get(position);
        holder.name.setText(peo.getName());
        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        Glide.with(mCtx).load(url+peo.getProfile_path()).apply(option).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
TextView name;
ImageView img;

        public PeopleViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.productName_people);
            img = itemView.findViewById(R.id.productImg_people);
        }
    }
}
