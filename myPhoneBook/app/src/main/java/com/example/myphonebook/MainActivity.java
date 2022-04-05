package com.example.myphonebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lvPhoneBook);
        adapter = new ViewAdapter();

        listView.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pic3),
                        "어머님", "01000000000");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pic2),
                "아버지", "01000000000");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.pic4),
                "누나", "01000000000");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long l) {
                ListViewItem item = (ListViewItem)parent.getItemAtPosition(position);

                String name = (String) item.getName();
                String telNum = (String) item.getTelNum();
                Drawable icon = (Drawable) item.getIcon();

                Uri uri = Uri.parse("tel:" + telNum);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(callIntent);

            }
        });
    }

}