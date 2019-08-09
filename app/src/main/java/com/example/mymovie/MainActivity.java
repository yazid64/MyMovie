package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
CardView cv_movie,cv_tv,cv_people;
private ViewPager viewPager;
ImageView img;
private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        img = findViewById(R.id.img_main);
//        viewPager = findViewById(R.id.view_pager);
        cv_movie = findViewById(R.id.cv_movie);
        cv_tv = findViewById(R.id.cv_tv);
        cv_people = findViewById(R.id.cv_people);


        cv_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,movie_main.class));
            }
        });

        cv_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.mymovie.people.MainActivity.class));
            }
        });

        cv_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,tvshow_main.class));
            }
        });
    }
}
