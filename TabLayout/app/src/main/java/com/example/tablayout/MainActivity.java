package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO : tab의 상태가 선택 상태로 변경.
                // 선택된 탭의 글귀를 가져온다. getText()활용.
                // Toast.makeText(MainActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
                // 몇 번째 요소인지 가져온다. getPosition()활용.
                int pos = tab.getPosition();
                visiblePage(pos);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // TODO : tab의 상태가 선택되지 않음으로 변경.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // TODO : 이미 선택된 tab을 다시
            }
        });
    }

    public void visiblePage(int position) {
        TextView txtTab1 = (TextView) findViewById(R.id.txtTab1);
        TextView txtTab2 = (TextView) findViewById(R.id.txtTab2);
        TextView txtTab3 = (TextView) findViewById(R.id.txtTab3);

        switch (position){
            case 0:
                txtTab1.setVisibility(View.VISIBLE);
                txtTab2.setVisibility(View.INVISIBLE);
                txtTab3.setVisibility(View.INVISIBLE);
                break;

            case 1:
                txtTab1.setVisibility(View.INVISIBLE);
                txtTab2.setVisibility(View.VISIBLE);
                txtTab3.setVisibility(View.INVISIBLE);
                break;

            case 2:
                txtTab1.setVisibility(View.INVISIBLE);
                txtTab2.setVisibility(View.INVISIBLE);
                txtTab3.setVisibility(View.VISIBLE);
                break;
        }

    }
}