package com.example.mymovie.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nowplaying);

        toolbar = findViewById(R.id.toolbar_nowplaying);
//        title = findViewById(R.id.title_movie_nowplaying);
        original_title = findViewById(R.id.originaltitle_movie_nowplaying);
        vote = findViewById(R.id.voteaverage_movie_nowplaying);
        release = findViewById(R.id.release_movie_nowplaying);
        popularity = findViewById(R.id.popularity_movie_nowplaying);
        img =  findViewById(R.id.img_movie_nowplaying);
        overview = findViewById(R.id.overview_movie_nowplaying);
        language = findViewById(R.id.language_movie_nowplaying);



        final model job = getIntent().getExtras().getParcelable("get");

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
//            title.setText(Title);
            popularity.setText(image);
            original_title.setText(Release);
            overview.setText(Overview);
            language.setText(Popularity);
            release.setText(Original_title);
            vote.setText(Language);


            RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
            String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
            Glide.with(this).load(url+Vote).apply(requestOptions).into(img);

            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(Title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//            getSupportActionBar().setDisplayShowCustomEnabled(true);
//            getSupportActionBar().setCustomView(R.layout.activity_detail_nowplaying);
//            ((TextView) findViewById(R.id.release_movie_nowplaying)).setText(Release);
    }


    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
