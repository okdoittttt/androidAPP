package com.example.jangun2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] count = new int[9];
        int[] imgId = {R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9};
        int[] imgSorce={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
        String[] imgName={"그림1","그림2","그림3","그림4","그림5","그림6","그림7","그림8","그림9"};

        for(int i=0 ;i<imgId.length;i++){
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
//        Button buttonR = (Button) findViewById(R.id.button11);
        btnR = (Button) findViewById(R.id.button11);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("imgSorce", imgSorce);
                intent.putExtra("imaName",imgName);
                intent.putExtra("count",count);

                startActivity(intent);
            }
        });
    }
}