package com.example.michaelli.ihopethisworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michaelli.ihopethisworks.categoryAdapters.meatAdp;

public class SingleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");
        meatAdp meatAdp = new meatAdp(this);

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        imageView.setImageResource(meatAdp.mThumbIds[position]);

        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(meatAdp.two[position]);

        TextView tv2 = (TextView) findViewById(R.id.text2);
        tv2.setText(meatAdp.three[position]);

        TextView header = (TextView) findViewById(R.id.headerTextSingle);
        header.setText(meatAdp.three[position]);

    }
}
