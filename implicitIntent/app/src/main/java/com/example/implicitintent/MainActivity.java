package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCall;
    Button btnWeb;
    Button btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Call Button
        btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("tel:/01099314582");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, url);
                startActivity(intentCall);
            }
        });

//      Web Button
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("http://naver.com");
                Intent intentCall = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intentCall);
            }
        });

//        Map Button
        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("geo:37.5543,126.9135");
                Intent intentCall = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intentCall);
            }
        });

    }
}