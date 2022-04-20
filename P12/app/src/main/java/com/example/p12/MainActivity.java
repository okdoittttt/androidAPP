package com.example.p12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] count = new int[9];
        int[] imgId = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView8, R.id.imageView9};
        int[] imgSorce = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        String[] name = {"Pic1", "Pic3", "Pic13", "Pic4", "Pic5", "Pic6", "Pic7", "Pic8", "Pic9"};

        for(int i=0 ;i<9;i++){
            int index = i;
            count[i] = 0;

            ImageView imageView = (ImageView) findViewById(imgId[i]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count[index]++;
                    Toast.makeText(MainActivity.this, count[index]+"", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("count", count);
                intent.putExtra("imgSorce", imgSorce);
                intent.putExtra("imgName", name);

                startActivity(intent);
            }
        });
    }
}