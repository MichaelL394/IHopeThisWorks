package com.example.michaelli.ihopethisworks;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class beginningScreen extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beggining_screen);


        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.firstScreen);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /** goes to meats and beans section */
    public void goToMeatsAndBeans(View view) {
        Intent i = new Intent(this, meatsForNow.class);
        startActivity(i);
    }

    /** goes to vegetable section */
    public void vegetable(View view) {
        Intent i = new Intent(this, vegetable.class);
        startActivity(i);
    }

    public void dairy(View view) {
        Intent i = new Intent(this, vegetable.class);
        startActivity(i);
    }

    public void grains(View view) {
        Intent i = new Intent(this, vegetable.class);
        startActivity(i);
    }

    public void fruits(View view) {
        Intent i = new Intent(this, vegetable.class);
        startActivity(i);
    }

    public void other(View view) {
        Intent i = new Intent(this, vegetable.class);
        startActivity(i);
    }



    //below is for pullout navigation menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }
}
