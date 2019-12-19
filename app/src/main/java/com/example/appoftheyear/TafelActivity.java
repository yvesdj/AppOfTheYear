package com.example.appoftheyear;

import java.lang.reflect.*;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.MenuKaart;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.lang.reflect.Constructor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class TafelActivity extends AppCompatActivity {

    private DatabaseReference _db;
//    private ValueEventListener _getMenu;

    private static MenuKaart menuKaart;

    private Tafel _dezeTafel;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FloatingActionButton _submitBtn;

    public FloatingActionButton getFloatingActionButton() {
        return _submitBtn;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);

        _db = FirebaseDatabase.getInstance().getReference();

        _dezeTafel = getIntent().getParcelableExtra("tafel");

        TextView tafelTitle = findViewById(R.id.TafelTitel);
        tafelTitle.setText("Tafel " + (_dezeTafel.tafelId));
        _submitBtn = findViewById(R.id.submitBtn);


        menuKaart = new MenuKaart();
        }
    @Override
    public void onStart() {

        super.onStart();
        Query menu = _db.child("Menu2");


        // [START basic_query_value_listener]
        // My top posts by number of stars
        menu.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {
                    // Get child of Menu name which is the class name
                    String category = categorySnapshot.getKey();
//                    Log.d("DBTest", category);

                    for (DataSnapshot itemSnapshot : dataSnapshot.child(category).getChildren()){
                        // Retrieve data from category children
                        String naam = String.valueOf(itemSnapshot.child("naam").getValue());
                        float prijs = Float.valueOf(String.valueOf(itemSnapshot.child("prijs").getValue()));

                        // See if child of menu == one of my classes
                        Class itemCategory = null;
                        try {
                            itemCategory = Class.forName("com.example.appoftheyear.classLibrary." + category);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        // define my constructor
                        Class[] parameters = new Class[] {String.class, float.class};

                        // bind constructor to my object
                        Constructor constructor = null;
                        try {
                            constructor = itemCategory.getConstructor(parameters);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                        // instantiate
                        Object menuItem = null;
                        try {
                            menuItem = constructor.newInstance(new Object[] {naam, prijs});
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        menuKaart.AddMenuItem((MenuItem) menuItem);
                        Log.d("DBTest", menuItem.toString());
                    }
                }
                Log.d("DBTest", String.valueOf(menuKaart.GetDesserten()));

                tabLayout = (TabLayout) findViewById(R.id.tablayout);
                viewPager = (ViewPager) findViewById(R.id.myViewPager);

                setViewPager(viewPager);
                tabLayout.setupWithViewPager(viewPager);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });

    }

    private void setViewPager(ViewPager viewPager){

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        Bundle args = generateBundle();

        Fragment voorgerechtenFragment = new VoorgerechtenFragment();
        viewPagerAdapter.addFragement(voorgerechtenFragment, "VOORGERECHTEN");
        voorgerechtenFragment.setArguments(args);

        Fragment hoofdgerechtenFragment = new HoofdgerechtenFragment();
        viewPagerAdapter.addFragement(hoofdgerechtenFragment,"HOOFGERECHTEN");
        hoofdgerechtenFragment.setArguments(args);
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

        args.putParcelableArrayList("desserten", menuKaart.GetDesserten());

        args.putParcelableArrayList("drinks", menuKaart.GetDrinks());
        return args;
    }
}
