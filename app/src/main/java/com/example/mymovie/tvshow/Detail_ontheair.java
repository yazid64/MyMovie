package com.example.mymovie.tvshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mymovie.R;
import com.example.mymovie.model.Tvshow;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detail_ontheair extends AppCompatActivity {
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
        setContentView(R.layout.activity_detail_ontheair);

        original_title = findViewById(R.id.originaltitle_tv_ontheair);
        vote = findViewById(R.id.voteaverage_tv_ontheair);
        release = findViewById(R.id.release_tv_ontheair);
        popularity = findViewById(R.id.popularity_tv_ontheair);
        img =  findViewById(R.id.img_tv_ontheair);
        overview = findViewById(R.id.overview_tv_ontheair);
        language = findViewById(R.id.language_tv_ontheair);

        final Tvshow job = getIntent().getExtras().getParcelable("get");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id_ontheair);
        collapsingToolbarLayout.setTitleEnabled(true);

        if (job != null) {
            String Title = job.getName();
            String image = job.getPoster_path();
            String Original_title = job.getOrginal_name();
            String Vote = job.getVote_average();
            String Release = job.getFirst_air_date();
            String Popularity = job.getPopularity();
            String Language = job.getOriginal_language();
            String Overview = job.getOverview();

            title.setText(Title);
            popularity.setText(Popularity);
            original_title.setText(Original_title);
            overview.setText(Overview);
            language.setText(Language);
            release.setText(Release);
            vote.setText(Vote);


            RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp).error(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
            String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
            Glide.with(this).load(url+image).apply(requestOptions).into(img);

        }

    }
}
