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
import android.widget.LinearLayout;
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
        int subCategory = i.getExtras().getInt("subCategory");

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        TextView header = findViewById(R.id.headerTextStart);
        TextView first = findViewById(R.id.textSingleView1);
        TextView second = findViewById(R.id.textSingleView2);

        //This selects which texts and images to use by picking which adapter, and plugging category integer in
        switch(category) {
            case 1: dairyAdp dairy = new dairyAdp(this, subCategory);
            switch(subCategory){
                case 0: imageView.setImageResource(dairy.allDairy[position]);
                    break;
                case 1: imageView.setImageResource(dairy.desserts[position]);
                    break;
                case 2: imageView.setImageResource(dairy.cream[position]);
                    break;
                case 3: imageView.setImageResource(dairy.allDairy[position]);
                    break;
                case 4: imageView.setImageResource(dairy.allDairy[position]);
                    break;
            }
                header.setText("dairy");
                first.setText(dairy.two[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            break;
            case 2: fruitAdp fruit = new fruitAdp(this, subCategory);
                switch(subCategory){
                    case 0: imageView.setImageResource(fruit.allfruit[position]);
                        break;
                    case 1: imageView.setImageResource(fruit.citrus[position]);
                        break;
                    case 2: imageView.setImageResource(fruit.tropical[position]);
                        break;
                }
                header.setText("fruit");
                first.setText(fruit.two[position]);
                break;
            case 3: grainAdp grain = new grainAdp(this, subCategory);
                switch(subCategory){
                    case 0: imageView.setImageResource(grain.allgrain[position]);
                        break;
                    case 1: imageView.setImageResource(grain.dessertsGr[position]);
                        break;
                    case 2: imageView.setImageResource(grain.baked[position]);
                        break;
                    case 3: imageView.setImageResource(grain.oatsandcereal[position]);
                        break;
                }
                header.setText("grain");
                first.setText(grain.two[position]);
                second.setText(grain.three[position]);
                break;
            case 4: meatAdp meat = new meatAdp(this, subCategory);
                switch(subCategory){
                    case 0: imageView.setImageResource(meat.allmeat[position]);
                        break;
                    case 1: imageView.setImageResource(meat.processed[position]);
                        break;
                    case 2: imageView.setImageResource(meat.raw[position]);
                        break;
                    case 3: imageView.setImageResource(meat.mammal[position]);
                        break;
                    case 4: imageView.setImageResource(meat.othermeat[position]);
                        break;
                }
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
                            case R.id.processed:
                                Intent processed = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "processed";
                                processed.putExtra("STRING_SEND", strName);
                                processed.putExtra("foodType", 3);
                                processed.putExtra("subType", 3);
                                startActivity(processed);
                                break;
                            case R.id.raw:
                                Intent raw = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "raw";
                                raw.putExtra("STRING_SEND", strName);
                                raw.putExtra("foodType", 3);
                                raw.putExtra("subType", 3);
                                startActivity(raw);
                                break;
                            case R.id.mammal:
                                Intent mammal = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "mammal";
                                mammal.putExtra("STRING_SEND", strName);
                                mammal.putExtra("foodType", 3);
                                mammal.putExtra("subType", 3);
                                startActivity(mammal);
                                break;
                            case R.id.othermeat:
                                Intent othermeat = new Intent(getApplicationContext(), generalGrid.class);
                                strName = "other meat";
                                othermeat.putExtra("STRING_SEND", strName);
                                othermeat.putExtra("foodType", 3);
                                othermeat.putExtra("subType", 3);
                                startActivity(othermeat);
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
