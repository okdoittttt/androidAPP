package com.example.p15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = (Button) findViewById(R.id.button1);
        Button btnMap = (Button) findViewById(R.id.button2);
        Button btnWeb = (Button) findViewById(R.id.button3);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:/01012341234");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intentCall);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:123.123.123");
                Intent intenMap = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intenMap);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://naver.com");
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentWeb);
            }
        });
    }
}