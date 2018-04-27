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
        int subCategory = retrieve.getExtras().getInt("subCategory");

        Intent sendToNav = new Intent(getApplicationContext(), dairyAdp.class);
        sendToNav.putExtra("sub", subCategory);

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

        //navigation menu handler
        android.support.design.widget.NavigationView
        navigationView = findViewById(R.id.gridview_nav);
        switch (foodCategory) {
            case 1:navigationView.inflateMenu(R.menu.dairy_menu);
            break;
            case 2:navigationView.inflateMenu(R.menu.fruits_menu);
            break;
            case 3:navigationView.inflateMenu(R.menu.grain_menu);
            break;
            case 4:navigationView.inflateMenu(R.menu.meats_menu);
            break;
            case 5:navigationView.inflateMenu(R.menu.other_menu);
            break;
            case 6:navigationView.inflateMenu(R.menu.vegetables_menu);
            break;
        }
                //navigation user selection handler
        navigationView.setNavigationItemSelectedListener(
                new android.support.design.widget.NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem Item) {
                        // set item as selected to persist highlight
                        Item.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int idOfMenuItem = Item.getItemId();


                        switch (idOfMenuItem) {
                            case R.id.nav1:
                                Intent dessert = new Intent(getApplicationContext(), generalGrid.class);
                                String strName = "dairy";
                                dessert.putExtra("STRING_SEND", strName);
                                dessert.putExtra("foodType", 1);
                                dessert.putExtra("subType", 1);
                                startActivity(dessert);
                                break;
                            case R.id.nav2:
                                Intent cream = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Fruits";
                                cream.putExtra("STRING_SEND", strName);
                                cream.putExtra("foodType", 1);
                                cream.putExtra("subType", 2);
                                startActivity(cream);
                                break;
                            case R.id.nav3:
                                Intent grain = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "grains";
                                grain.putExtra("STRING_SEND", strName);
                                grain.putExtra("foodType", 3);
                                grain.putExtra("subType", 1);
                                startActivity(grain);
                                break;



                        }
                        return true;
                    }
                });
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