package com.example.michaelli.ihopethisworks;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.michaelli.ihopethisworks.categoryAdapters.*;

public class SingleViewActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        Intent i = getIntent();
        // Selected image id
        int position = i.getExtras().getInt("id");
        int category = i.getExtras().getInt("category");

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        TextView header = findViewById(R.id.headerTextStart);
        TextView first = findViewById(R.id.textSingleView1);
        TextView second = findViewById(R.id.textSingleView2);

        //This selects which text and image to use by picking which adapter, and plugging category number in
        switch(category) {
            case 1: dairyAdp dairy = new dairyAdp(this);
                imageView.setImageResource(dairy.mThumbIds[position]);
                header.setText("dairy");
                first.setText(dairy.two[position]);
            break;
            case 2: fruitAdp fruit = new fruitAdp(this);
                imageView.setImageResource(fruit.mThumbIds[position]);
                header.setText("fruit");
                first.setText(fruit.two[position]);
                break;
            case 3: grainAdp grain = new grainAdp(this);
                imageView.setImageResource(grain.mThumbIds[position]);
                header.setText("grain");
                first.setText(grain.two[position]);
                break;
            case 4: meatAdp meat = new meatAdp(this);
                imageView.setImageResource(meat.mThumbIds[position]);
                header.setText("meat");
                first.setText(meat.two[position]);
                break;
            case 5: otherAdp other = new otherAdp(this);
                imageView.setImageResource(other.mThumbIds[position]);
                header.setText("other");
                first.setText(other.two[position]);
                break;
            case 6: vegetablesAdp vegetables = new vegetablesAdp(this);
                imageView.setImageResource(vegetables.mThumbIds[position]);
                header.setText("vegetables");
                first.setText(vegetables.two[position]);
                break;
}

        mToolBar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.singleDrawerView);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        NavigationView navigationView = findViewById(R.id.singleViewNavigation);
        switch (category) {
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
}
