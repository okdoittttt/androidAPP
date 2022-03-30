// 참고 URL : https://recipes4dev.tistory.com/43

package com.example.movielistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listViewMoviePoster;
    LisvtViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMoviePoster = (ListView)findViewById(R.id.lvMoviePoster);
        adapter = new LisvtViewAdapter();

        listViewMoviePoster.setAdapter(adapter);

        // 불러오고자 할 때는 (R.drawable.element) ContextCompat을 사용한다.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie1),
                "title 1", "description 1");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie2),
                "title 2", "description 2");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie3),
                "title 3", "description 3");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie4),
                "title 4", "description 4");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie5),
                "title 5", "description 5");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie6),
                "title 6", "description 6");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie7),
                "title 7", "description 7");
    }
}