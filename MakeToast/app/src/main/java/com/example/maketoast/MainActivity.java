package com.example.maketoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R = res
    }

    public void btnClick(View view) {
        Toast.makeText(getApplicationContext(), "손옥무 010-4003-0631", Toast.LENGTH_LONG).show();
    }
}