package com.example.mymovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymovie.R;
import com.example.mymovie.model.model;
import com.example.mymovie.movie.Detail_nowplaying;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    RequestOptions option;
    Context mContext;
//    List<model> mData;
    ArrayList<model>arrayList;
    public RecyclerViewAdapter(Context mContext,ArrayList<model>arrayList){
        this.mContext = mContext;
        this.arrayList = arrayList;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_movie_nowplaying,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);
//        vHolder.cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(mContext,Detail_nowplaying.class);
//                i.putExtra("title",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("vote_average",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("popularity",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("original_language",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("original_title",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("overview",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("release_date",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                i.putExtra("poster_path",arrayList.get(vHolder.getAdapterPosition()).getTitle());
//                mContext.startActivity(i);
//            }
//        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

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

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView productname,original_title,release,vote,popularity,language,overview;
        ImageView imageproduct;
CardView cv;
         public MyViewHolder(final View itemview){
            super(itemview);
            productname = (TextView)itemview.findViewById(R.id.productName_nowplaying);
            imageproduct = (ImageView)itemview.findViewById(R.id.productImg_nowplaying);
            cv = itemview.findViewById(R.id.List_movie_Nowplaying);
             original_title = (TextView)itemview.findViewById(R.id.originaltitle_movie_nowplaying);
//             release = (TextView)itemview.findViewById(R.id.release_movie_nowplaying);
             vote = (TextView)itemview.findViewById(R.id.voteaverage_movie_nowplaying);
             popularity = (TextView)itemview.findViewById(R.id.popularity_movie_nowplaying);
             language = (TextView)itemview.findViewById(R.id.language_movie_nowplaying);
             overview = (TextView)itemview.findViewById(R.id.overview_movie_nowplaying);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext,Detail_nowplaying.class);
                    i.putExtra("get",arrayList.get(getAdapterPosition()));
                    mContext.startActivity(i);
                }
            });
        }
    }
}
