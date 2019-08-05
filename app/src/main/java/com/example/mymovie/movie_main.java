package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mymovie.adapter.ViewPagerAdapter;
import com.example.mymovie.movie.fragment_movie_nowplaying;
import com.example.mymovie.movie.fragment_movie_popular;
import com.example.mymovie.movie.fragment_movie_toprated;
import com.example.mymovie.movie.fragment_movie_upcoming;
import com.example.mymovie.tvshow.fragment_tvshow_populer;
import com.google.android.material.tabs.TabLayout;

public class movie_main extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout_movie);
        viewPager = (ViewPager)findViewById(R.id.view_pager_movie);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new fragment_movie_nowplaying(),"NowPlaying");
        adapter.AddFragment(new fragment_movie_popular(),"Popular");
        adapter.AddFragment(new fragment_movie_toprated(),"TopRated");
        adapter.AddFragment(new fragment_movie_upcoming(),"Upcoming");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
