package com.ListViewAdapter;

import com.example.hs_project.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class collectionAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] myCollection = {R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon,
    		R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon, R.drawable.druidicon};
 
    public collectionAdapter(Context c) {
        mContext = c;
    }
 
    public int getCount() {
        return myCollection.length;
    }
 
    public Object getItem(int position) {
        return null;
    }
 
    public long getItemId(int position) {
        return 0;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
 
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));// ancho
            // y alto
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(myCollection[position]);
        return imageView;
    }

}
