package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;


import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.MenuKaart;
import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.util.ArrayList;
import java.util.LinkedList;

public class TafelActivity extends AppCompatActivity {

//    private final LinkedList<Voorgerecht> voorgerechten = new LinkedList<>();
    private static MenuKaart menuKaart;
    private ArrayList<String> voorgerechtNamen;




    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);


        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);
        menuKaart = new MenuKaart();
        voorgerechtNamen = menuKaart.GetVoorgerechtNamen();

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);





//        ArrayList<Hoofdgerecht> hoofdgerechten= menuKaart.GetHoofdgerechten();

        }




    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());



        Bundle args = new Bundle();
        args.putStringArrayList("voorgerechtNamen", voorgerechtNamen);
        Fragment voorgerechtenFragment = new VoorgerechtenFragment();
        viewPagerAdapter.addFragement(voorgerechtenFragment, "VOORGERECHTEN");
//        viewPagerAdapter.addFragement(new VoorgerechtenFragment(), "VOORGERECHTEN");
        voorgerechtenFragment.setArguments(args);


        viewPagerAdapter.addFragement(new HoofdgerechtenFragment(),"HOOFGERECHTEN");
        viewPagerAdapter.addFragement(new DessertFragment(),"DESSERTEN");
        viewPagerAdapter.addFragement(new DrinksFragment(),"DRINKS");
        viewPagerAdapter.addFragement(new BestellingFragment(),"BESTELLINGEN");
        viewPager.setAdapter(viewPagerAdapter);

    }

}
