package com.example.p12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] imgId = intent.getIntArrayExtra("imgSorce");
        int[] count = intent.getIntArrayExtra("count");
        String[] name = intent.getStringArrayExtra("imgName");

        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        for (int i=0; i<count.length; i++)
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
