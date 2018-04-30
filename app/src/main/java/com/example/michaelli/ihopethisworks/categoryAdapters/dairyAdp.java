package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;


public class dairyAdp extends BaseAdapter {

    int nav_sel = 0;

    private Context mContext;

    // Constructor

    public dairyAdp(Context c, int resources) {
        mContext = c;
        nav_sel = resources;
    }

    public int getCount() {
            return allDairy.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }


    // create new ImageViews in grid based on (selected array here).length or number of items in selected array
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
// this calls which image in which array to use for each generated imageview button
        switch (nav_sel){
            case 0:imageView.setImageResource(allDairy[position]);
            break;
            case 1: imageView.setImageResource(cream[position]);
            break;
            case 2: imageView.setImageResource(cream[position]);
        }

        return imageView;
    }

    // sub categories in arrays
    public Integer[] allDairy = {
            R.drawable.butter, R.drawable.ice_cream,
            R.drawable.candy,

    };
    public Integer[] desserts = {
            R.drawable.butter, R.drawable.ice_cream,
            R.drawable.candy,

    };
        public Integer[] cream = {
            R.drawable.ice_cream, R.drawable.bannana,
            R.drawable.butter,

    };





    public String[] two = {
           //Butter
            "Butter may be stored for 1-2 days in room temperature \n Can last 1-2 months if stored in a refrigerator on the date of purchase",
            //Ice cream
            "cartos \n cats \n dog","drugos",("elepant" + '\n' +
            "dog"), "cat"
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}