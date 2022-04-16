package com.example.p2;

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
        setContentView(R.layout.resut);

        Intent intent = getIntent();
        int[] imgId = intent.getIntArrayExtra("imgSource");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] name = intent.getStringArrayExtra("imgName");

        MyAdapter adapter = new MyAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        for(int i=0; i< voteCount.length; i++)
        {
            adapter.addItem(imgId[i], voteCount[i], name[i]);
        }

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
