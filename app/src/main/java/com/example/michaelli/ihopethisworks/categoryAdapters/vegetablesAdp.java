package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;

public class vegetablesAdp extends BaseAdapter {
    private Context mContext;

    // Constructor
    public vegetablesAdp(Context c) {
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
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.artichoke, R.drawable.broccoli
    };



    public String[] two = {
           //artichoke
            "Artichokes should be stored in the fridge in a moisture rich environment. ",
            //broccoli
            "Broccoli should be stored loosely in the fridge, inside the crisper drawer, wrapped in a damp towel. Broccoli can be blanched and put in the freezer in an airtight container."
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}