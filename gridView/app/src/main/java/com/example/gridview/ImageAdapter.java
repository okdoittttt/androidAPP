package com.example.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    int[] imageId = {R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,
            R.drawable.movie1, R.drawable.movie2, R.drawable.movie3, R.drawable.movie4,};


    public ImageAdapter(Context c) { mContext = c; }

    public int getCount() { return imageId.length; }
    public Object getItem(int i) { return null; }
    public long getItemId(int i) { return 0; }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
//            이미지 디자인 소스
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageId[position]);
        return imageView;
    }
}
