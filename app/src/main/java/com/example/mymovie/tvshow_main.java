package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mymovie.adapter.ViewPagerAdapter;
import com.example.mymovie.tvshow.fragment_tvshow_airingtoday;
import com.example.mymovie.tvshow.fragment_tvshow_ontheair;
import com.example.mymovie.tvshow.fragment_tvshow_populer;
import com.example.mymovie.tvshow.fragment_tvshow_toprated;
import com.google.android.material.tabs.TabLayout;

public class tvshow_main extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_main);

//        tabLayout = (TabLayout)findViewById(R.id.tab_layout_tvshow);
//        viewPager = (ViewPager)findViewById(R.id.view_pager_tvshow);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new fragment_tvshow_airingtoday(),"AiringToday");
        adapter.AddFragment(new fragment_tvshow_ontheair(),"OnTheAir");
        adapter.AddFragment(new fragment_tvshow_populer(),"Popular");
        adapter.AddFragment(new fragment_tvshow_toprated(),"TopRated");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
