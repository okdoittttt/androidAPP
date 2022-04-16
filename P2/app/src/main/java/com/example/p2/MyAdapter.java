package com.example.p2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Item> items = new ArrayList<>();
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            Context context = viewGroup.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.itemlayout, viewGroup, false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView name = (TextView) view.findViewById(R.id.textView);
        TextView voteCount = (TextView) view.findViewById(R.id.textView2);

        Item item = items.get(i);

        imageView.setImageResource(item.getImgId());
        name.setText(item.getName());
        voteCount.setText(item.getVoteCount()+"");


        return view;
    }

    public void addItem(int imgId, int voteCount, String name) {
        Item item = new Item(imgId, voteCount, name);
        items.add(item);
    }
}
