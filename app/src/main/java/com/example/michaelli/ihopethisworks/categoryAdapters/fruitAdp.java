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

            switch (subCategory){
                case 0: imageView.setImageResource(allfruit[position]);
                    break;
                case 1: imageView.setImageResource(citrus[position]);
                    break;
                case 2: imageView.setImageResource(tropical[position]);
            }
            switch(subCategory){
                case 0: tV.setText(three[position]);
                    break;
                default:tV.setText(three[position]);
                    break;
            }
        }
        else
            {
            container = convertView;
            }

        return container;
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
            //Apples
            "Store apples in the fridge to extend shelf life \n -Apples should be stored seperate from other produce as they release large amounts of ethylene." +
                    "A single bruised apple can shorten the shelf life of other fruits stored with it; so remember to eat bruised apples first.",
            //banana
            "-Bannanas should be stored loose, eg. on the counter \n -Bananas also give off ethylene gas, which speeds ripening in other produce. Freezing bananas can be used to further extend shelf life.",
            //strawberries
            "-Strawberries should be stored in a container lined with a dry towel, and the container should have air circulation when not refrigerated. \n " +
                    "Before storing berries, remove any spoiled or crushed fruits, and store unwashed in an airtight container when in the refrigerator to keep from drying",
            "cat", "watermelon",
    };
    public String[] three = {
            "apples","carrots","strawberries","tomatoes", "watermelons", "dog"
    };

}