package com.example.phonebook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    // list에 ListViewItem를 담을 객체(배열)를 생성
    ArrayList<ListViewItem> list = new ArrayList<ListViewItem>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    // getView 메소드는 View를 return 한다. 여기서 View는 Item들을 말한다.
    public View getView(int position, View convertView, ViewGroup parent) {
        // parent정보를 가져와 context에 저장, list View 가 있는 activity를 칮아오기 위함.
        Context context = parent.getContext();

        if(convertView == null)
        {
            // 기준점을 잠아준다.
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, parent, false);
        }

        // icon, title, description을 찾아와 넣어준다.
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);

        //  Data Set 에서 position에 위치한 데이터 참조 획득
        ListViewItem item = (ListViewItem)list.get(position);
        // 위젯에 데이터 반영
        icon.setImageDrawable(item.getIcon());
        title.setText(item.getTitle());
        description.setText(item.getDescription());

        return convertView;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable icon, String title, String description) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDescription(description);

        list.add(item);
    }
}