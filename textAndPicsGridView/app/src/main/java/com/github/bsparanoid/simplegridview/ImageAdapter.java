package com.github.bsparanoid.simplegridview;

/**
 * Created by bsparanoid on 05/03/17.
 */

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context _Context;
    private final String[] _descriptionText;
    private final Integer[] _Imageid;

    // Constructor
    public ImageAdapter(Context c, String[] descriptionText, Integer[] Imageid) {
        _Context = c;
        _descriptionText = descriptionText;
        _Imageid = Imageid;
    }

    public int getCount() {
        return _Imageid.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View grid;
        LayoutInflater inflater = (LayoutInflater) _Context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(_Context);
            grid = inflater.inflate(R.layout.component_of_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(_descriptionText[position]);
            imageView.setImageResource(_Imageid[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }
}