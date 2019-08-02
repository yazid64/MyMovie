package com.example.mymovie;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mymovie.Fragment.fragment_movie;
import com.example.mymovie.Fragment.fragment_tvshow;
import com.example.mymovie.adapter.adpter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private adpter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
viewPagerAdapter = new adpter(getSupportFragmentManager());
viewPagerAdapter.Addfragment(new fragment_movie(),"Movie");
        viewPagerAdapter.Addfragment(new fragment_tvshow(),"Tv_Show");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
