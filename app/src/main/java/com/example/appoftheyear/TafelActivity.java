package com.example.appoftheyear;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.appoftheyear.classLibrary.Dessert;
import com.example.appoftheyear.classLibrary.Drink;
import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.MenuKaart;
import com.example.appoftheyear.classLibrary.Tafel;
import com.example.appoftheyear.classLibrary.Voorgerecht;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class TafelActivity extends AppCompatActivity {

    private static ArrayList<MenuItem> _menuItems;
    private  static ArrayList<Voorgerecht> _voorgerechten;
    private  static ArrayList<Hoofdgerecht> _hoofdgerechten;
    private static ArrayList<Drink> _drinks;
    private static ArrayList<Dessert> _desserts;

    private DatabaseReference Voorgerechtendb = FirebaseDatabase.getInstance().getReference().child("Menu/Voorgerechten");


    private static MenuKaart menuKaart;


    private Tafel _dezeTafel;



    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);
        _voorgerechten = new ArrayList<>();
        Voorgerechtendb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    String naam = String.valueOf(dataSnapshot1.child("naam").getValue());
                 //  float prijs = Float.valueOf(dataSnapshot1.child("prijs").getValue(float.class));
                   float prijs = Float.valueOf(String.valueOf(dataSnapshot1.child("prijs").getValue()));
                  // Voorgerecht voorgerecht = new Voorgerecht(naam,prijs);

                    _voorgerechten.add(new Voorgerecht(naam,prijs));
                   // Log.d("voorgerechtdb", String.valueOf(voorgerecht));
                }

                menuKaart = new MenuKaart(_voorgerechten);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        _dezeTafel = getIntent().getParcelableExtra("tafel");

        TextView tafelTitle = findViewById(R.id.TafelTitel);
        tafelTitle.setText("Tafel " + (_dezeTafel.Get_tafelId()+1));

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);




        Log.d("Tafels", String.valueOf(_dezeTafel.Get_tafelId()));

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
