package com.example.jungan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int result = 0;
    String num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnP = (Button) findViewById(R.id.button1);
        Button btnM = (Button) findViewById(R.id.button2);
        Button btnMu = (Button) findViewById(R.id.button3);
        Button btnD = (Button) findViewById(R.id.button4);

        TextView textView = (TextView) findViewById(R.id.textView);
        EditText ed1 = (EditText) findViewById(R.id.ed1);
        EditText ed2 = (EditText) findViewById(R.id.ed2);

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                result = Integer.parseInt(num1)+Integer.parseInt(num2);
                textView.setText("결과:"+result);
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                result = Integer.parseInt(num1)-Integer.parseInt(num2);
                textView.setText("결과:"+result);
            }
        });

        btnMu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                result = Integer.parseInt(num1)*Integer.parseInt(num2);
                textView.setText("결과:"+result);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = ed1.getText().toString();
                num2 = ed2.getText().toString();
                Double result = Double.parseDouble(num1)/Double.parseDouble(num2);
                textView.setText("결과:"+result);
            }
        });
    }
}