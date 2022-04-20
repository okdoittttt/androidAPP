package com.example.p10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String numR1, numR2;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView txtResult = (TextView) findViewById(R.id.textView);

        Button plus = (Button) findViewById(R.id.Plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numR1 = num1.getText().toString();
                numR2 = num2.getText().toString();
                result = Integer.parseInt(numR1)+Integer.parseInt(numR2);
                txtResult.setText("Result "+result);
            }
        });

        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numR1 = num1.getText().toString();
                numR2 = num2.getText().toString();
                result = Integer.parseInt(numR1)-Integer.parseInt(numR2);
                txtResult.setText("Result "+result);
            }
        });

        Button multi = (Button) findViewById(R.id.multiply);
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numR1 = num1.getText().toString();
                numR2 = num2.getText().toString();
                result = Integer.parseInt(numR1)*Integer.parseInt(numR2);
                txtResult.setText("Result "+result);
            }
        });

        Button divi = (Button) findViewById(R.id.divi);
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numR1 = num1.getText().toString();
                numR2 = num2.getText().toString();
                double result = Double.parseDouble(numR1)/Double.parseDouble(numR2);
                txtResult.setText("Result "+result);
            }
        });
    }
}