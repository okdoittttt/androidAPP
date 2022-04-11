package com.example.testwellpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class voteResult extends AppCompatActivity {

    RatingBar[] rBar;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);

        Intent intentReceive = getIntent();
        int[] hitCount = intentReceive.getIntArrayExtra("hc");
        rBar = new RatingBar[9];
        int[] rBarId = {R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3, R.id.ratingBar4, R.id.ratingBar5, R.id.ratingBar6, R.id.ratingBar7, R.id.ratingBar8, R.id.ratingBar9};

        for(int i=0; i<rBar.length; i++) {
            rBar[i] = (RatingBar)findViewById(rBarId[i]);
            rBar[i].setRating((float)hitCount[i]);
        }

        btnReturn = (Button)findViewById(R.id.btnExit);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}