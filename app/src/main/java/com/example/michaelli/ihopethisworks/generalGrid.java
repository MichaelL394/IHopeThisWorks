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
        final int subCategory = retrieve.getExtras().getInt("subType");
        String headerTitle = retrieve.getExtras().getString("STRING_SEND");


        TextView header = findViewById(R.id.headerTextStart);

        //selects which food Adapter to use based on user selection of category
        switch (foodCategory) {
            case 1:  gridview.setAdapter(new dairyAdp(this, subCategory));
                        header.setText(headerTitle);
                break;
            case 2:  gridview.setAdapter(new fruitAdp(this, subCategory));
                        header.setText(headerTitle);
                break;
            case 3:  gridview.setAdapter(new grainAdp(this, subCategory));
                        header.setText(headerTitle);
                break;
            case 4:  gridview.setAdapter(new meatAdp(this));
                        header.setText(headerTitle);
                break;
            case 5:  gridview.setAdapter(new otherAdp(this));
                        header.setText(headerTitle);
                break;
            case 6:  gridview.setAdapter(new vegetablesAdp(this));
                        header.setText(headerTitle);
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
                i.putExtra("subCategory", subCategory);
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

        //navigation bar menu handler
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

                    //sends the id of which category was chosen in nav bar and opens another gridview based on user choice
                        switch (idOfMenuItem) {
                            case R.id.desserts:
                                Intent dessert = new Intent(getApplicationContext(), generalGrid.class);
                                String strName = "desserts";
                                dessert.putExtra("STRING_SEND", strName);
                                dessert.putExtra("foodType", 1);
                                dessert.putExtra("subType", 1);
                                startActivity(dessert);
                                break;
                            case R.id.cream:
                                Intent cream = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "cream";
                                cream.putExtra("STRING_SEND", strName);
                                cream.putExtra("foodType", 1);
                                cream.putExtra("subType", 2);
                                startActivity(cream);
                                break;
                            case R.id.cheese:
                                Intent cheese = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "cheese";
                                cheese.putExtra("STRING_SEND", strName);
                                cheese.putExtra("foodType", 1);
                                cheese.putExtra("subType", 3);
                                startActivity(cheese);
                                break;
                            case R.id.yogurt:
                                Intent yogurt = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "yogurt";
                                yogurt.putExtra("STRING_SEND", strName);
                                yogurt.putExtra("foodType", 1);
                                yogurt.putExtra("subType", 4);
                                startActivity(yogurt);
                                break;
                            case R.id.Citrus:
                                Intent Citrus = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Citrus";
                                Citrus.putExtra("STRING_SEND", strName);
                                Citrus.putExtra("foodType", 2);
                                Citrus.putExtra("subType", 1);
                                startActivity(Citrus);
                                break;
                            case R.id.Tropical:
                                Intent Tropical = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Tropical";
                                Tropical.putExtra("STRING_SEND", strName);
                                Tropical.putExtra("foodType", 2);
                                Tropical.putExtra("subType", 2);
                                startActivity(Tropical);
                                break;
                            case R.id.dessertsGr:
                                Intent dessertsGr = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "desserts";
                                dessertsGr.putExtra("STRING_SEND", strName);
                                dessertsGr.putExtra("foodType", 3);
                                dessertsGr.putExtra("subType", 1);
                                startActivity(dessertsGr);
                                break;
                            case R.id.baked:
                                Intent baked = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "baked";
                                baked.putExtra("STRING_SEND", strName);
                                baked.putExtra("foodType", 3);
                                baked.putExtra("subType", 2);
                                startActivity(baked);
                                break;
                            case R.id.oatsandcereal:
                                Intent oatsandcereal = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Oats and Cereal";
                                oatsandcereal.putExtra("STRING_SEND", strName);
                                oatsandcereal.putExtra("foodType", 3);
                                oatsandcereal.putExtra("subType", 3);
                                startActivity(oatsandcereal);
                                break;

                            case R.id.dairy:
                                Intent dairy = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "dairy";
                                dairy.putExtra("STRING_SEND", strName);
                                dairy.putExtra("foodType", 1);
                                dairy.putExtra("subType", 0);
                                startActivity(dairy);
                                break;
                            case R.id.fruits:
                                Intent fruits = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Fruits";
                                fruits.putExtra("STRING_SEND", strName);
                                fruits.putExtra("foodType", 2);
                                fruits.putExtra("subType", 0);
                                startActivity(fruits);
                                break;
                            case R.id.grains:
                                Intent grains = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Grains";
                                grains.putExtra("STRING_SEND", strName);
                                grains.putExtra("foodType", 3);
                                grains.putExtra("subType", 0);
                                startActivity(grains);
                                break;
                            case R.id.meats:
                                Intent meats = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Meats";
                                meats.putExtra("STRING_SEND", strName);
                                meats.putExtra("foodType", 4);
                                meats.putExtra("subType", 0);
                                startActivity(meats);
                                break;
                            case R.id.other:
                                Intent other = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "other";
                                other.putExtra("STRING_SEND", strName);
                                other.putExtra("foodType", 5);
                                other.putExtra("subType", 0);
                                startActivity(other);
                                break;
                            case R.id.vegetables:
                                Intent vegetables = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Vegetables";
                                vegetables.putExtra("STRING_SEND", strName);
                                vegetables.putExtra("foodType", 6);
                                vegetables.putExtra("subType", 0);
                                startActivity(vegetables);
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