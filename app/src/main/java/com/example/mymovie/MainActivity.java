package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
CardView cv_movie,cv_tv,cv_people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv_movie = findViewById(R.id.cv_movie);
        cv_tv = findViewById(R.id.cv_tv);
        cv_people = findViewById(R.id.cv_people);

        cv_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pindah class movie
            }
        });

        cv_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pindah class people
            }
        });

        cv_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pindah class tv
            }
        });
    }
}
