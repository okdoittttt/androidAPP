package com.example.wellpicturevote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] voteCount;
    ImageView[] image;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voteCount = new int[9];
        for(int i=0; i<voteCount.length; i++) {
            voteCount[i] = 0;
        }

        image = new ImageView[voteCount.length];
        int[] imageId = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView9};
        String[] imgName = {"그림1", "그림2", "그림3", "그림4", "그림5", "그림6", "그림7", "그림8", "그림9"};

        for(int i=0; i<voteCount.length; i++) {
            final int index;
            index = i;

            image[index] = (ImageView)findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imgName[index] + "번이 " + voteCount[index] + "번 눌러졌습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            btnExit = (Button)findViewById(R.id.button01);
            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentHitCount = new Intent(getApplicationContext(), VoteResult.class);
                    intentHitCount.putExtra("hc", voteCount);
                    startActivity(intentHitCount);
                }
            });
        }
    }


}