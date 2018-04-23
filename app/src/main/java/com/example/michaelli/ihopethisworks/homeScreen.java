package com.example.michaelli.ihopethisworks;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class homeScreen extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.firstScreen);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //navigation user selection handler
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem Item) {
                        // set item as selected to persist highlight
                        Item.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int idOfMenuItem = Item.getItemId();

                        switch (idOfMenuItem) {
                            case R.id.nav1:
                                Intent dairy = new Intent(getApplicationContext(), generalGrid.class);
                                String strName = "dairy";
                                dairy.putExtra("STRING_SEND", strName);
                                dairy.putExtra("foodType", 1);
                                startActivity(dairy);
                                break;
                            case R.id.nav2:
                                Intent fruits = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "Fruits";
                                fruits.putExtra("STRING_SEND", strName);
                                fruits.putExtra("foodType", 2);
                                startActivity(fruits);
                                break;
                            case R.id.nav3:
                                Intent grain = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "grains";
                                grain.putExtra("STRING_SEND", strName);
                                grain.putExtra("foodType", 3);
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


    // all below handles the actions after user selects a category of food
    public void dairy(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "dairy";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 1);
        startActivity(i);
    }

    public void fruits(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "Fruits";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 2);
        startActivity(i);
    }

    public void grains(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "vegetables";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 3);
        startActivity(i);
    }

    /** goes to meats and beans section */
    public void goToMeatsAndBeans(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "meats and beans";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 4);
        startActivity(i);
    }

    public void other(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "vegetables";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 5);
        startActivity(i);
    }

    /** goes to vegetables section */
    public void vegetable(View view) {
        Intent i = new Intent(this, generalGrid.class);
        String strName = "vegetables";
        i.putExtra("STRING_SEND", strName);
        i.putExtra("foodType", 6);
        startActivity(i);
    }


}
