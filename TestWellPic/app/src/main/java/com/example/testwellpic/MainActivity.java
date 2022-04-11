package com.example.testwellpic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
        int[] imageId = {R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5,
                R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView9};
        String[] imageName = {"pic1", "pic2", "pic3", "pic4", "pic5", "pic6", "pic7", "pic8", "pic9"};

        for(int i=0; i<voteCount.length; i++) {
            final int index = i;

            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imageName[index]+" push "+voteCount[index], Toast.LENGTH_SHORT).show();
                }
            });
            btnExit = (Button)findViewById(R.id.btnExit);
            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentHitCount = new Intent(getApplicationContext(), voteResult.class);
                    intentHitCount.putExtra("hc", voteCount);
                    startActivity(intentHitCount);
                }
            });
        }
    }
}