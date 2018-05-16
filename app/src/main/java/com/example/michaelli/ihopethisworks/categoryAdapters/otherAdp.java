package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michaelli.ihopethisworks.R;

public class otherAdp extends BaseAdapter {
    private Context mContext;

    // Constructor
    public otherAdp(Context c) {
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
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View container;
        ImageView imageView;
        TextView tV;


        if (convertView == null) {
            container = new View(mContext);
            container = inflater.inflate(R.layout.grid_organize, null);

            tV = container.findViewById(R.id.grid_text);

            imageView = container.findViewById(R.id.grid_image);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tV.setText("cow");
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
            R.drawable.a, R.drawable.b,
    };



    public String[] two = {
           "drugs","cartos \n cats \n dog","drugos",("elepant" + '\n' +
            "dog"), "cat"
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}