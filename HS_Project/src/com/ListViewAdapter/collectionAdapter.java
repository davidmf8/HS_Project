package com.ListViewAdapter;

import java.io.BufferedInputStream;
import java.io.IOException;

import com.example.hs_project.R;
import com.example.hs_project.R.layout;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;

public class collectionAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] myCollection = {R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate,
    		R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate, R.drawable.innervate};
    private int copias = R.drawable.copia1;
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
        GridHolder imageView;
        if (convertView == null) {
        	LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        	convertView = inflater.inflate(layout.item_gridview, parent, false);
            imageView = new GridHolder();
            imageView.numItem = (ImageView) convertView.findViewById(R.id.item_text);
            imageView.imageItem = (ImageView) convertView.findViewById(R.id.item_image);
            Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            int alto;
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2){
            		display.getSize(size);
            			alto = size.y;
            }
            else {
            	alto = display.getHeight();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, alto/4);
            layoutParams.gravity = Gravity.CENTER;
            imageView.imageItem.setLayoutParams(layoutParams);
            layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            imageView.numItem.setLayoutParams(layoutParams);
            convertView.setTag(imageView);
        } else {
            imageView = (GridHolder)convertView.getTag();
        }

        imageView.imageItem.setImageResource(myCollection[position]);
        imageView.numItem.setImageResource(copias);
        return convertView;
    }
    
    static class GridHolder {
    	ImageView numItem;
    	ImageView imageItem; 
    }

}
