package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;

public class dairyAdp extends BaseAdapter {
    private Context mContext;

    // Constructor
    public dairyAdp(Context c) {
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
            imageView.setLayoutParams(new GridView.LayoutParams(375, 375));
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
            R.drawable.butter, R.drawable.ice_cream,
            R.drawable.milk, R.drawable.half_and_half
    };


    public String[] two = {
           //Butter
            "Butter can be stored for 1-2 days in room temperature. It can last up to 1-2 months if stored in a refrigerator on the date of purchase",
            //Ice cream
            "Ice cream can be stored in the freezer for 2-3 months or 1-2 months after being opened",
            //milk
            "Milk can be stored in the fridge for 5 days after being opened",
            //half and half
            "Half and half can be stored in the fridge for up to 10 days"
            //yogurt
            "Yogurt can be kept in the fridge for up to 6 weeks unopened and 7 to 10 days after opening"
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}