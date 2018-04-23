package com.example.michaelli.ihopethisworks;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.michaelli.ihopethisworks.categoryAdapters.dairyAdp;
import com.example.michaelli.ihopethisworks.categoryAdapters.fruitAdp;
import com.example.michaelli.ihopethisworks.categoryAdapters.grainAdp;
import com.example.michaelli.ihopethisworks.categoryAdapters.meatAdp;
import com.example.michaelli.ihopethisworks.categoryAdapters.otherAdp;
import com.example.michaelli.ihopethisworks.categoryAdapters.vegetablesAdp;

import org.w3c.dom.Text;

public class generalGrid extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        Intent retrieve = getIntent();
        final int foodCategory = retrieve.getExtras().getInt("foodType");

        TextView header = findViewById(R.id.headerTextStart);

        switch (foodCategory) {
            case 1:  gridview.setAdapter(new dairyAdp(this));
                        header.setText("Dairy");
                break;
            case 2:  gridview.setAdapter(new fruitAdp(this));
                        header.setText("Fruit");
                break;
            case 3:  gridview.setAdapter(new grainAdp(this));
                        header.setText("Grain");
                break;
            case 4:  gridview.setAdapter(new meatAdp(this));
                        header.setText("Meat");
                break;
            case 5:  gridview.setAdapter(new otherAdp(this));
                        header.setText("Other");
                break;
            case 6:  gridview.setAdapter(new vegetablesAdp(this));
                        header.setText("Vegetables");
                break;
            default: gridview.setAdapter(new meatAdp(this));
                break;
        }

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                // Send intent to SingleViewActivity
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                // Pass image index
                i.putExtra("id", position);
                i.putExtra("category", foodCategory);
                startActivity(i);

            }
        });

        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayoutMeat);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    //below is for pullout navigation menu hamburger button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}