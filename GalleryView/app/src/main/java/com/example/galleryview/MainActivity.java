package com.example.galleryview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView mainImg = (ImageView) findViewById(R.id.mainImg);;
        int[] imgId = {R.drawable.canada, R.drawable.france, R.drawable.korea, R.drawable.mexico,
                R.drawable.poland, R.drawable.saudi_arabia};

        Gallery gallery = (Gallery) findViewById(R.id.galFlag);
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), R.layout.row, imgId);

        gallery.setAdapter(myAdapter);

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mainImg.setImageResource(imgId[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}