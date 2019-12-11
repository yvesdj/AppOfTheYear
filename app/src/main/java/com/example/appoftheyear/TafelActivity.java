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
    private ArrayList<String> _voorgerechtNamen;
    private ArrayList<String> _hoofdgerechtNamen;
    private ArrayList<String> _dessertNamen;
    private ArrayList<String> _drinksNamen;




    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);


        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);

        menuKaart = new MenuKaart();

        _voorgerechtNamen = menuKaart.GetVoorgerechtNamen();
        _hoofdgerechtNamen = menuKaart.GetHoofdgerechtNamen();
        _dessertNamen = menuKaart.GetDessertNamen();
        _drinksNamen = menuKaart.GetDrinksNamen();


        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);





//        ArrayList<Hoofdgerecht> hoofdgerechten= menuKaart.GetHoofdgerechten();

        }




    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());



        Bundle args = new Bundle();
        args.putStringArrayList("voorgerechtNamen", _voorgerechtNamen);
        args.putStringArrayList("hoofdgerechtNamen", _hoofdgerechtNamen);
        args.putStringArrayList("dessertNamen", _dessertNamen);
        args.putStringArrayList("drinksNamen", _drinksNamen);

        Fragment voorgerechtenFragment = new VoorgerechtenFragment();
        viewPagerAdapter.addFragement(voorgerechtenFragment, "VOORGERECHTEN");
//        viewPagerAdapter.addFragement(new VoorgerechtenFragment(), "VOORGERECHTEN");
        voorgerechtenFragment.setArguments(args);

        Fragment hoofdgerechtenFragment = new HoofdgerechtenFragment();
        viewPagerAdapter.addFragement(hoofdgerechtenFragment,"HOOFGERECHTEN");
        hoofdgerechtenFragment.setArguments(args);
//
        Fragment dessertenFragment = new DessertFragment();
        viewPagerAdapter.addFragement(dessertenFragment,"DESSERTEN");
        dessertenFragment.setArguments(args);

        Fragment drinksFragment = new DrinksFragment();
        viewPagerAdapter.addFragement(drinksFragment,"DRINKS");
        drinksFragment.setArguments(args);

        viewPagerAdapter.addFragement(new BestellingFragment(),"BESTELLINGEN");
        viewPager.setAdapter(viewPagerAdapter);

    }

}
