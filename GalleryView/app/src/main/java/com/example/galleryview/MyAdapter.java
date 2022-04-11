package com.example.galleryview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int xmlId;
    int[] imgId;

    LayoutInflater inflater;

    MyAdapter (Context c, int layout, int[] imgId) {
        this.context = c;
        this.xmlId = layout;
        this.imgId = imgId;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() { return imgId.length; }

    public Object getItem(int i) { return null; }

    public long getItemId(int i) { return 0; }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(xmlId, null);

        ImageView view = (ImageView) convertView.findViewById(R.id.imgFlag);
        view.setImageResource(imgId[position]);

        return convertView;
    }
}
