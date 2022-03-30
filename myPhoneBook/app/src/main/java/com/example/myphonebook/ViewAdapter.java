package com.example.myphonebook;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewAdapter extends BaseAdapter {

    ArrayList<ListViewItem> list = new ArrayList<ListViewItem>();

    public int getCount() { return list.size(); }
    public Object getItem(int position) { return list.get(position); }
    public long getItemId(int position) { return position; }

    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem, parent, false);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView telNum = (TextView) convertView.findViewById(R.id.telNum);

        ListViewItem item = (ListViewItem) list.get(position);
        icon.setImageDrawable(item.getIcon());
        name.setText(item.getName());
        telNum.setText(item.getTelNum());

        return convertView;
    }

    public void addItem(Drawable icon, String name, String telNum) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setName(name);
        item.setTelNum(telNum);

        list.add(item);
    }
}
