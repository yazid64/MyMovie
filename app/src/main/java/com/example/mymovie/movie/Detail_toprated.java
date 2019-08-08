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

public class Detail_toprated extends AppCompatActivity {
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
        setContentView(R.layout.activity_detail_toprated);

        toolbar = findViewById(R.id.toolbar_toprated);
        original_title = findViewById(R.id.originaltitle_movie_toprated);
        vote = findViewById(R.id.voteaverage_movie_top);
        release = findViewById(R.id.release_movie_toprated);
        popularity = findViewById(R.id.popularity_movie_top);
        img =  findViewById(R.id.img_movie_top);
        overview = findViewById(R.id.overview_movie_top);
        language = findViewById(R.id.language_movie_top);

        final model job = getIntent().getExtras().getParcelable("get");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id_toprated);
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
