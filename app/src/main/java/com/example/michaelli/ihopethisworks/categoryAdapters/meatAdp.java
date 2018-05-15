package com.example.michaelli.ihopethisworks.categoryAdapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.michaelli.ihopethisworks.R;

public class meatAdp extends BaseAdapter {
    private Context mContext;
    private int recievesub = 0;

    // Constructor
    public meatAdp(Context c, int subCategory) {
        mContext = c;
        recievesub = subCategory;
    }

    public int getCount() {
        Integer[] category = allmeat;
        switch (recievesub){
            case 0:category = allmeat;
                break;
            case 1:category = processed;
                break;
            case 2:category = raw;
                break;
            case 3:category = mammal;
                break;
            case 4:category = othermeat;
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
            imageView.setLayoutParams(new GridView.LayoutParams(330, 330));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        switch (recievesub){
            case 0: imageView.setImageResource(allmeat[position]);
                break;
            case 1: imageView.setImageResource(processed[position]);
                break;
            case 2: imageView.setImageResource(raw[position]);
                break;
            case 3: imageView.setImageResource(mammal[position]);
                break;
            case 4: imageView.setImageResource(othermeat[position]);
                break;
        }
        return imageView;
    }

    // Keep all Images in array
    public Integer[] allmeat = {
            R.drawable.lunch_meat, R.drawable.pork,
            R.drawable.hotdog, R.drawable.corned_beef,
            R.drawable.hamburger_patty, R.drawable.goat_chunks
    };
    public Integer[] processed = {
            R.drawable.lunch_meat, R.drawable.b,
            R.drawable.a
    };
    public Integer[] raw = {
            R.drawable.lunch_meat, R.drawable.b,
            R.drawable.a
    };
    public Integer[] mammal = {
            R.drawable.lunch_meat, R.drawable.b,
            R.drawable.a
    };
    public Integer[] othermeat = {
            R.drawable.lunch_meat, R.drawable.b,
            R.drawable.a
    };

    // example of skip line syntax ("elepant" + '\n' +"dog") or "cartos \n cats \n dog","drugos"
    public String[] two = {
            //lunch meet aka shark skin
            "Lunch meat can be stored in the fridge for up to two weeks in the fridge before opening. After the meat is opened it can be stored in the fridge for 3-5 days in the fridge. Lunch meats can be stored in the freezer indefinitely but should be eaten within 2 months for maximum freshness ",
            //Pork
            "For best quality, fresh pork roast, steaks, chops or ribs should be used within 4 - 6 months; fresh ground pork, pork liver or variety meats should be used within 3 - 4 months; and home cooked pork; soups, stews or casseroles within 2 - 3 months. After that they will still be safe but may lose quality or dry out.",
           //Hot Dogs
            "Packaged hot dogs can be stored in the refrigerator 2 weeks before opening. After opening a package of hot dogs you can keep them for a week in the refrigerator (40 °F/4.4 °C or less). These meats can also be frozen for 1 to 2 months for best quality. Frozen foods are safe indefinitely.",
            //COrned Beef
            "Corned beef is made from one of several less tender cuts of beef like the brisket, rump or round. Therefore, it requires long, moist cooking. Corned beef is safe once the internal temperature has reached at least 145 °F (62.8 °C) with a three minute rest time, but cooking it longer will make it fork-tender. Corned beef may still be pink in color after cooking. This does not mean it is not done. Nitrite is used in the curing process. This fixes pigment in the meat and affects the color.",
            //Hamburger
            "If ground beef is refrigerated promptly after cooking (within 2 hours; 1 hour if the temperature is above 90 °F (32.2 °C), it can be safely refrigerated for about 3 or 4 days. If frozen, it should keep its quality for about 4 months. When reheating fully cooked patties or casseroles containing ground beef, be sure the internal temperature reaches 165 °F (73.8 °C) or it is hot and steaming.",
            //Goat Meat
            "Store ground goat meat only 1 or 2 days in the refrigerator before either cooking or freezing it. Roasts, steaks and chops can be kept refrigerated 3 to 5 days before cooking. After cooking, keep refrigerated 3 to 4 days. For best quality, cooked meat and raw ground meat can be frozen and used within 3 to 4 months. Raw steaks, roasts and chops can be kept frozen 6 to 9 months. However, any frozen meat is safe indefinitely. Only the quality (flavor, texture, moistness) decreases during longer storage."
    };
    public String[] three = {
            "staves","cartos","drugos",("elepant" + '\n' +
            "dog"), "cat", "dog"
    };

}