package com.example.p3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Result extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent intent = getIntent();
        int[] imgId = intent.getIntArrayExtra("imgSor");
        int[] count = intent.getIntArrayExtra("count");
        String[] name = intent.getStringArrayExtra("imgName");

        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        for(int i=0; i< count.length; i++)
        {
            adapter.addItem(imgId[i], count[i], name[i]);
        }

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
