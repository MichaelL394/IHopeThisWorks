package com.example.michaelli.ihopethisworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michaelli.ihopethisworks.categoryAdapters.*;

public class SingleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");
        int category = i.getExtras().getInt("category");

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        TextView header = findViewById(R.id.headerTextSingle);

        switch(category) {
            case 1: dairyAdp dairy = new dairyAdp(this);
                imageView.setImageResource(dairy.mThumbIds[position]);
                header.setText("dairy");
            break;
            case 2: fruitAdp fruit = new fruitAdp(this);
                imageView.setImageResource(fruit.mThumbIds[position]);
                header.setText("fruit");
                break;
            case 3: grainAdp grain = new grainAdp(this);
                imageView.setImageResource(grain.mThumbIds[position]);
                header.setText("grain");
                break;
            case 4: meatAdp meat = new meatAdp(this);
                imageView.setImageResource(meat.mThumbIds[position]);
                header.setText("meat");
                break;
            case 5: otherAdp other = new otherAdp(this);
                imageView.setImageResource(other.mThumbIds[position]);
                header.setText("other");
                break;
            case 6: vegetablesAdp vegetables = new vegetablesAdp(this);
                imageView.setImageResource(vegetables.mThumbIds[position]);
                header.setText("vegetables");
                break;
}



    }
}
