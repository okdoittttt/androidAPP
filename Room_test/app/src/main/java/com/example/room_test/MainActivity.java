package com.example.room_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mtxt;
    private TextView mresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxt = findViewById(R.id.toto_edit);
        mresult = findViewById(R.id.textView);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db").allowMainThreadQueries().build();

        mresult.setText(db.todoDao().getAll().toString());

        Button btn = (Button) findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.todoDao().insert(new Todo(mtxt.getText().toString()));
                mresult.setText(db.todoDao().getAll().toString());
            }
        });
    }
}