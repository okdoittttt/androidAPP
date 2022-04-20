package com.example.p11;

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

        Button btnCall = (Button) findViewById(R.id.button);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:/01040030631");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intentCall);
            }
        });

        Button btnWeb = (Button) findViewById(R.id.button2);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://google.com");
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentWeb);
            }
        });

        Button btnMap = (Button) findViewById(R.id.button3);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:37.5543,126.9135");
                Intent intentMap = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentMap);
            }
        });
    }
}