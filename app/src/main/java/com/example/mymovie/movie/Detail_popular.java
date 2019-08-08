package com.example.mymovie.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymovie.R;
import com.example.mymovie.model.model;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detail_popular extends AppCompatActivity {
    TextView language;
    TextView overview;
    ImageView img;
    TextView popularity;
    TextView release;
    TextView vote;
    TextView original_title;
    TextView title;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);

        toolbar = findViewById(R.id.toolbar_popular);
        original_title = findViewById(R.id.originaltitle_movie_popular);
        vote = findViewById(R.id.voteaverage_movie_pop);
        release = findViewById(R.id.release_movie_popular);
        popularity = findViewById(R.id.popularity_movie_pop);
        img =  findViewById(R.id.img_movie_pop);
        overview = findViewById(R.id.overview_movie_pop);
        language = findViewById(R.id.language_movie_pop);

        final model job = getIntent().getExtras().getParcelable("get");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id_pop);
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
            title.setText(Title);
            popularity.setText(image);
            original_title.setText(Release);
            overview.setText(Overview);
            language.setText(Popularity);
            release.setText(Original_title);
            vote.setText(Language);

            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(Title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
            String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
            Glide.with(this).load(url+Vote).apply(requestOptions).into(img);

        }

    }
}

