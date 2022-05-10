package com.example.namecard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // public 사용될 변수 선언
    public String name, tell, email;    // 입력받은 text
    public Handler handler;             // 오류처리 Toast
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 오류처리에 사용될 Handler 객체.
        Handler handler = new Handler();

        // Create Edit Text Object
        EditText inputName = (EditText) findViewById(R.id.inputName);
        EditText inputTell = (EditText) findViewById(R.id.inputTell);
        EditText inputEmail = (EditText) findViewById(R.id.inputEmail);

        // Button Save, Search
        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력받은 Text를 String 변수 안에 넣어준다.
                name = inputName.getText().toString();
                tell = inputTell.getText().toString();
                email = inputEmail.getText().toString();

                dataInsert(name, tell, email);
            }
        });
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
    }

    // 데이터베이스에 입력된 텍스트를 DB에 삽입하는 Method.
    public void dataInsert(String name, String tell, String email) {
        new Thread() {
            public void run() {
                try
                {
                    URL setURL = new URL("Http://10.0.2.2/insert03.php/");
                    HttpURLConnection http;
                    http = (HttpURLConnection) setURL.openConnection();

                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("_").append(tell).append("_").append(email).append("_");

                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                    outStream.write(buffer.toString());
                    outStream.flush();

                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    while ((str=reader.readLine()) != null) {
                        Log.e("ㄱㅏ나다라마바사아ㅏㄴ암ㄴㅇ람ㄴ앎낭람ㄴㅇㄹ", str);
//                        System.out.println(reader.readLine());
                    }
                } catch (Exception e)
                {
                    Log.e("", "에러발생"+e);
                }
            }
        }.start();
    }
}