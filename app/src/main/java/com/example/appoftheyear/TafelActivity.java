package com.example.appoftheyear;

import android.os.Bundle;

import com.example.appoftheyear.classLibrary.MenuKaart;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class TafelActivity extends AppCompatActivity {

//    private final LinkedList<Voorgerecht> voorgerechten = new LinkedList<>();
    private static MenuKaart menuKaart;


    private Tafel _dezeTafel;
//    private ArrayList<String> _bestellingNamen;


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);


        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);

        menuKaart = new MenuKaart();

        _dezeTafel = new Tafel();
//        _bestellingNamen = _dezeTafel.GetBestellingenNamen();

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        }




    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle args = generateBundle();

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

        Fragment bestellingFragment = new BestellingFragment();
        viewPagerAdapter.addFragement(bestellingFragment,"BESTELLINGEN");
        bestellingFragment.setArguments(args);

        viewPager.setAdapter(viewPagerAdapter);

    }

    private Bundle generateBundle(){
        Bundle args = new Bundle();
        args.putParcelable("tafel", _dezeTafel);
//        args.putStringArrayList("besteldeItems", _bestellingNamen);

        args.putParcelableArrayList("voorgerechten", menuKaart.GetVoorgerechten());
        args.putParcelableArrayList("hoofdgerechten", menuKaart.GetHoofdgerechten());

//        args.putStringArrayList("dessertNamen", _dessertNamen);
        args.putParcelableArrayList("desserten", menuKaart.GetDesserten());

        args.putParcelableArrayList("drinks", menuKaart.GetDrinks());
        return args;
    }
}
