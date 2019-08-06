package com.example.mymovie.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymovie.R;
import com.example.mymovie.model.model;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detail_nowplaying extends AppCompatActivity {
    TextView language;
    TextView overview;
    ImageView img;
    TextView popularity;
    TextView release;
    TextView vote;
    TextView original_title;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nowplaying);

        title = findViewById(R.id.title_movie_nowplaying);
        original_title = findViewById(R.id.originaltitle_movie_nowplaying);
        vote = findViewById(R.id.voteaverage_movie_nowplaying);
        release = findViewById(R.id.release_movie_nowplaying);
        popularity = findViewById(R.id.popularity_movie_nowplaying);
        img =  findViewById(R.id.img_movie_nowplaying);
        overview = findViewById(R.id.overview_movie_nowplaying);
        language = findViewById(R.id.language_movie_nowplaying);

        model job = getIntent().getExtras().getParcelable("get");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        if (job != null) {
            String Title = job.getTitle();
            String image = job.getImage();
            String Original_title = job.getOriginal_title();
            String Vote = job.getVote_average();
            String Release = job.getRelease_date();
            String Popularity = job.getPopularity();
            String Language = job.getOriginal_language();
            String Overview = job.getOverview();
//        String Title  = getIntent().getExtras().getString("title");
//        String Vote = getIntent().getExtras().getString("vote_average");
//        String Popularity = getIntent().getExtras().getString("popularity") ;
//        String Language = getIntent().getExtras().getString("original_language");
//        String Original_title = getIntent().getExtras().getString("original_title") ;
//        String Overview = getIntent().getExtras().getString("overview") ;
//        String Release = getIntent().getExtras().getString("release_date") ;
//        String image = getIntent().getExtras().getString("poster_path") ;

            title.setText(Title);
            popularity.setText(Popularity);
            original_title.setText(Original_title);
            overview.setText(Overview);
            language.setText(Language);
            release.setText(Release);
            vote.setText(Vote);


            RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);

            Glide.with(this).load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + image).apply(requestOptions).into(img);

    }

    }
}
