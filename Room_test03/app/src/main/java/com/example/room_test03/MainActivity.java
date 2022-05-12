package com.example.room_test03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.room_test03.Adapters.NotesListAdapter;
import com.example.room_test03.Database.RoomDB;
import com.example.room_test03.Models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
    RoomDB database;
    FloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_home);
        fab_add = findViewById(R.id.fab_add);

        database = RoomDB.getInstance(this);
        notes = database.mainDAO().getAll();

        updateRecycler(notes);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NodesTakerActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    private void updateRecycler(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        notesListAdapter = new NotesListAdapter(MainActivity.this, notes, notesClickListener);
        recyclerView.setAdapter(notesListAdapter);
    }

    private  final NotesClickListener notesClickListener = new NotesClickListener() {
        @Override
        public void onClick(Notes notes) {

        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {

        }
    };
}