package com.github.bsparanoid.simplegridview;

/**
 * Created by bsparanoid on 05/03/17.
 */

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300)); /* case grid size 300x300 */
            imageView.setScaleType(ImageView.ScaleType.FIT_START); /* position of the image in the case */
            imageView.setPadding(8, 8, 8, 8); /* space -> top bottom right left of an case */
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    /* Keep all Images in array */
    public Integer[] mThumbIds = {
            R.drawable.logo_1, R.drawable.logo_11, R.drawable.logo_2, R.drawable.logo_10,
            R.drawable.logo_3, R.drawable.logo_9, R.drawable.logo_4, R.drawable.logo_8,
            R.drawable.logo_5, R.drawable.logo_7, R.drawable.logo_6, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_5, R.drawable.logo_8, R.drawable.logo_4,
            R.drawable.logo_9, R.drawable.logo_3, R.drawable.logo_10, R.drawable.logo_2,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_1, R.drawable.logo_11,
            R.drawable.logo_2, R.drawable.logo_10, R.drawable.logo_3, R.drawable.logo_9,
            R.drawable.logo_4, R.drawable.logo_8, R.drawable.logo_5, R.drawable.logo_7,
            R.drawable.logo_6, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_5,
            R.drawable.logo_8, R.drawable.logo_4, R.drawable.logo_9, R.drawable.logo_3,
            R.drawable.logo_10, R.drawable.logo_2, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_1, R.drawable.logo_11, R.drawable.logo_2, R.drawable.logo_10,
            R.drawable.logo_3, R.drawable.logo_9, R.drawable.logo_4, R.drawable.logo_8,
            R.drawable.logo_5, R.drawable.logo_7, R.drawable.logo_6, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_5, R.drawable.logo_8, R.drawable.logo_4,
            R.drawable.logo_9, R.drawable.logo_3, R.drawable.logo_10, R.drawable.logo_2,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_10
    };
}