package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;

public class fruitAdp extends BaseAdapter {
    private Context mContext;

    int subCategory = 0;
    // Constructor
    public fruitAdp(Context c, int subcategory) {
        mContext = c;
        subCategory = subcategory;
    }

    public int getCount() {
        Integer[] category = allfruit;
        switch (subCategory){
            case 0:category = allfruit;
                break;
            case 1:category = citrus;
                break;
            case 2:category = tropical;
                break;
        }
        return category.length;
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
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        switch (subCategory){
            case 0: imageView.setImageResource(allfruit[position]);
                break;
            case 1: imageView.setImageResource(citrus[position]);
                break;
            case 2: imageView.setImageResource(tropical[position]);
        }
        return imageView;
    }

    // Keep all Images in array
    public Integer[] allfruit = {
            R.drawable.apples, R.drawable.bananas,
            R.drawable.strawberries, R.drawable.tomatoes,
            R.drawable.watermelons,
    };
    public Integer[] citrus = {
            R.drawable.apples, R.drawable.bananas,
            R.drawable.strawberries, R.drawable.tomatoes,
            R.drawable.watermelons,
    };
    public Integer[] tropical = {
            R.drawable.apples, R.drawable.bananas,
            R.drawable.strawberries, R.drawable.tomatoes,
            R.drawable.watermelons,
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