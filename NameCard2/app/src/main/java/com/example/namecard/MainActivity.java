package com.example.namecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edName = (EditText) findViewById(R.id.edName);
        EditText edTell = (EditText) findViewById(R.id.edTell);
        EditText edEmail = (EditText) findViewById(R.id.edEmail);

        Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataInsert();
            }
        });
    }

    private void dataInsert() {
        new Thread();
        public void run() {
            try {
                URL dbUrl = new URL("Http://127.01.01.01/insert.php/");
            }
        }
    }
}