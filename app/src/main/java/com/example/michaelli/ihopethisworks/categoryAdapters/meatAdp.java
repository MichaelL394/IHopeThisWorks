package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;

public class meatAdp extends BaseAdapter {
    private Context mContext;

    // Constructor
    public meatAdp(Context c) {
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
            R.drawable.lunch_meat, R.drawable.pork,
            R.drawable.hotdogs
    };

    // example of skip line syntax ("elepant" + '\n' +"dog") or "cartos \n cats \n dog","drugos"
    public String[] two = {
            //lunch meet aka shark skin
            "Lunch meat can be stored in the fridge for up to two weeks in the fridge before opening. After the meat is opened it can be stored in the fridge for 3-5 days in the fridge. Lunch meats can be stored in the freezer indefinitely but should be eaten within 2 months for maximum freshness ",
            //Pork
            "For best quality, fresh pork roast, steaks, chops or ribs should be used within 4 - 6 months; fresh ground pork, pork liver or variety meats should be used within 3 - 4 months; and home cooked pork; soups, stews or casseroles within 2 - 3 months. After that they will still be safe but may lose quality or dry out.",
           //Hot Dogs
            "Packaged hot dogs can be stored in the refrigerator 2 weeks before opening. After opening a package of hot dogs you can keep them for a week in the refrigerator (40 °F/4.4 °C or less). These meats can also be frozen for 1 to 2 months for best quality. Frozen foods are safe indefinitely.", "cat"
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}