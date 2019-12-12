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




    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);


       tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);


        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);







    }

    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragement(new VoorgerechtenFragment(), "VOORGERECHTEN");
        viewPagerAdapter.addFragement(new HoofdgerechtenFragment(),"HOOFGERECHTEN");
        viewPagerAdapter.addFragement(new DessertFragment(),"DESSERS");
        viewPagerAdapter.addFragement(new DrinksFragment(),"DRINKS");
        viewPagerAdapter.addFragement(new BestellingFragment(),"BESTELLINGEN");
        viewPager.setAdapter(viewPagerAdapter);

    }

}
