package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.mymovie.adapter.ViewPagerAdapter;
import com.example.mymovie.movie.fragment_nowplaying;
import com.example.mymovie.movie.fragment_populer;
import com.example.mymovie.movie.fragment_toprated;
import com.example.mymovie.movie.fragment_upcoming;
import com.google.android.material.tabs.TabLayout;

public class movieMain extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new fragment_nowplaying(),"NowPlaying");
        adapter.AddFragment(new fragment_populer(),"Popular");
        adapter.AddFragment(new fragment_toprated(),"TopRated");
        adapter.AddFragment(new fragment_upcoming(),"Upcoming");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
