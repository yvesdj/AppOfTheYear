package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;


import java.util.LinkedList;

public class TafelActivity extends AppCompatActivity {



    private final LinkedList<Voorgerecht> voorgerechten = new LinkedList<>();
    private RecyclerView recyclerView;
    private MenuListAdapter adapter;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);

       toolbar =(Toolbar) findViewById(R.id.myToolbar);
       tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);

        setSupportActionBar(toolbar);
        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);





        for (int i = 0; i < 20; i++) {
            String naam = "voorgerecht " + i;
            voorgerechten.addLast(new Voorgerecht(naam , 4));
            Log.d("Voorgerechten", "Value: " + naam);

        }
        Voorgerecht voorgerecht2 = voorgerechten.get(1);
        Log.d("Voorgerechten", "Value: " + voorgerecht2);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MenuListAdapter(this, voorgerechten);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragement(new VoorgerechtenFragment(), "VOORGERECHTEN");
        viewPagerAdapter.addFragement(new HoofdgerechtenFragment(),"HOOFGERECHTEN");
        viewPagerAdapter.addFragement(new DessertFragment(),"DESSERS");
        viewPagerAdapter.addFragement(new DrinksFragment(),"DRINKS");
        viewPager.setAdapter(viewPagerAdapter);

    }

}
