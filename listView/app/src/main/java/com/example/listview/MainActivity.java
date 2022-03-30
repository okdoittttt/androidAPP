package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvFruit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFruit = (ListView)findViewById(R.id.lvFruit);
        String[] val = {"01040030631", "01099314582", "01051520631", "01067070631", "01080084582", "과일6", "과일7", "과일8", "과일9", "과일10", "과일11", "과일12",
                    "과일13", "과일14", "과일15", "과일16", "과일17", "과일18", "과일19", "과일20"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, val);
        lvFruit.setAdapter(adapter);

        lvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String data = (String) adapterView.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("tel:" + data);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(callIntent);
            }
        });
    }
}