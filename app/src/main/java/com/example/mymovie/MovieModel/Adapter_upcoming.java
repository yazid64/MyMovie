package com.example.mymovie.MovieModel;

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
import com.example.mymovie.movie.Detail_upcoming;

import java.util.ArrayList;

public class Adapter_upcoming extends RecyclerView.Adapter<Adapter_upcoming.MyViewHolder>{

    RequestOptions option;
    Context mContext;
    //    List<model> mData;
    ArrayList<model> arrayList;

    public Adapter_upcoming(Context mContext, ArrayList<model> arrayList){
        this.mContext = mContext;
        this.arrayList = arrayList;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_movie_upcoming,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final model mModel = arrayList.get(position);

        String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
        holder.productname.setText(mModel.getTitle());
//        holder.original_title.setText(mModel.getOriginal_title());
//        holder.overview.setText(mModel.getOverview());
//        holder.release.setText(mModel.getRelease_date());
//        holder.vote.setText(mModel.getVote_average());
//        holder.language.setText(mModel.getOriginal_language());
//        holder.popularity.setText(mModel.getPopularity());
        Glide.with(mContext).load(url+mModel.getImage()).apply(option).into(holder.imageproduct);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productname,original_title,release,vote,popularity,language,overview;
        ImageView imageproduct;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productname = (TextView)itemView.findViewById(R.id.productName_upcoming);
            imageproduct = (ImageView)itemView.findViewById(R.id.productImg_upcoming);
            original_title = (TextView)itemView.findViewById(R.id.originaltitle_movie_nowplaying);
//            release = (TextView)itemView.findViewById(R.id.release_movie_nowplaying);
            vote = (TextView)itemView.findViewById(R.id.voteaverage_movie_nowplaying);
            popularity = (TextView)itemView.findViewById(R.id.popularity_movie_nowplaying);
            language = (TextView)itemView.findViewById(R.id.language_movie_nowplaying);
            overview = (TextView)itemView.findViewById(R.id.overview_movie_nowplaying);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext, Detail_upcoming.class);
                    i.putExtra("upcoming",arrayList.get(getAdapterPosition()));
                    mContext.startActivity(i);
                }
            });
        }
    }
}
