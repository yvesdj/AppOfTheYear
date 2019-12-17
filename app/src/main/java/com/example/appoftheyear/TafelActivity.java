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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);

        _db = FirebaseDatabase.getInstance().getReference();

        _dezeTafel = getIntent().getParcelableExtra("tafel");

        TextView tafelTitle = findViewById(R.id.TafelTitel);
        tafelTitle.setText("Tafel " + (_dezeTafel.Get_tafelId()+1));

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.myViewPager);

        menuKaart = new MenuKaart();

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        }
    @Override
    public void onStart() {

        super.onStart();
        Query menuVoorgerechten = _db.child("Menu2");


        // [START basic_query_value_listener]
        // My top posts by number of stars
        menuVoorgerechten.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot : dataSnapshot.getChildren()) {

                    String category = categorySnapshot.getKey();
//                    Log.d("DBTest", category);

                    for (DataSnapshot itemSnapshot : dataSnapshot.child(category).getChildren()){

                        String naam = String.valueOf(itemSnapshot.child("naam").getValue());
                        float prijs = Float.valueOf(String.valueOf(itemSnapshot.child("prijs").getValue()));

                        Class itemCategory = null;
                        try {
                            itemCategory = Class.forName("com.example.appoftheyear.classLibrary." + category);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        // I need an array as follows to describe the signature
                        Class[] parameters = new Class[] {String.class, float.class};

                        // Now I can get a reference to the right constructor
                        Constructor constructor = null;
                        try {
                            constructor = itemCategory.getConstructor(parameters);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }

                        // And I can use that Constructor to instantiate the class
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
                        Log.d("DBTest", String.valueOf(menuItem));
                        Log.d("DBTest", menuItem.toString());
                    }

//                    String naam = (String)itemSnapshot.child("naam").getValue();
//                    float prijs = itemSnapshot.child("prijs").getValue();
//                    MenuItem item = itemSnapshot.getValue(MenuItem.class);
//                    Log.d("DBTest", itemSnapshot.toString());
//                    Log.d("DBTest", item.toString());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });

//        ValueEventListener getMenu = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
//
//                    String naam = (String)itemSnapshot.child("naam").getValue();
////                    float prijs = (float)itemSnapshot.child("prijs").getValue();
//
//                    MenuItem item = new MenuItem(naam, 5);
//
//                    Log.d("DBTest", itemSnapshot.toString());
//                    Log.d("DBTest", item.toString());
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
//                // ...
//            }
//        };
//        // [END basic_query_value_listener]
//        _db.addListenerForSingleValueEvent(getMenu);
//
//        _getMenu = getMenu;
    }

//    public void onStart() {
//        super.onStart();
//
//        // Add value event listener to the post
//        // [START post_value_event_listener]
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                Post post = dataSnapshot.getValue(Post.class);
//                // [START_EXCLUDE]
//                mAuthorView.setText(post.author);
//                mTitleView.setText(post.title);
//                mBodyView.setText(post.body);
//                // [END_EXCLUDE]
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                // [START_EXCLUDE]
//                Toast.makeText(PostDetailActivity.this, "Failed to load post.",
//                        Toast.LENGTH_SHORT).show();
//                // [END_EXCLUDE]
//            }
//        };
//        mPostReference.addValueEventListener(postListener);
//        // [END post_value_event_listener]
//
//        // Keep copy of post listener so we can remove it when app stops
//        mPostListener = postListener;
//
//        // Listen for comments
//        mAdapter = new CommentAdapter(this, mCommentsReference);
//        mCommentsRecycler.setAdapter(mAdapter);
//    }


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

//    public void onStart() {
//        // [START write_message]
//        // Write a message to the database
//        super.onStart();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//        // [END write_message]
//
//        // [START read_message]
//        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("DBTest", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("DBTest", "Failed to read value.", error.toException());
//            }
//        });
//        // [END read_message]
//    }

}
