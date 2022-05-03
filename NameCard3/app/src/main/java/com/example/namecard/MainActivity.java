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
                    URL url = new URL("http://10.0.2.2:8888/insert.php");                     // 10.0.2.2 는 Android 에서 실행될 때 주소이다.
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    // PHP에 대한 설정.
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    // Data를 차곡차곡 쌓아 놓는다.
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("/").append(tell).append("/").append(email).append("/");
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader inReader = new InputStreamReader(http.getInputStream(), "UTF-8");
                    final BufferedReader reader = new BufferedReader(inReader);

                    while (reader.readLine() != null)
                    {
                        System.out.println(reader.readLine());
                    }
                } catch (Exception e)
                {
                    // Android 에서는 main Thread 만 자기에게 요청된 요청을 처리할 수 있다.
                    // 따라서 핸들러에서 Toast 를 요청하도록 한다.
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, "입력실패", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    Log.e("", ""+e);
                }
            }
        }.start();
    }
}