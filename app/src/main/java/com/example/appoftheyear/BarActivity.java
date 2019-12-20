package com.example.appoftheyear;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Drink;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class BarActivity extends AppCompatActivity {

    private DatabaseReference _db;
    private Query _qDrinks;
//    private boolean _isPulled = false;

    private HashMap<String, ArrayList<Drink>> _tafelDrinks;

//    private ArrayList<Tafel> _tafels = new ArrayList<>();
    private ArrayList<Drink> _drinksT1 = new ArrayList<>();

    private ListView drinksListView;
    private ArrayAdapter<Drink> drinkArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        _db = FirebaseDatabase.getInstance().getReference();

        drinksListView = findViewById(R.id.drinksListView);
        drinkArrayAdapter = new ArrayAdapter<Drink>(this, android.R.layout.simple_list_item_1, _drinksT1);
        drinksListView.setAdapter(drinkArrayAdapter);

//        _qTafel.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot tafelSnapshot : dataSnapshot.getChildren()) {
//                    String naam = String.valueOf(tafelSnapshot.child("naam").getValue());
//                    float prijs = Float.valueOf(String.valueOf(tafelSnapshot.child("prijs").getValue()));
//                    Drink drink = new Drink(naam, prijs);
//                    _drinksT1.add(drink);
//                    drinkArrayAdapter.notifyDataSetChanged();
//                    Log.d("BarTafels", String.valueOf(_drinksT1));
//                }
//                _isPulled = true;
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
//            }
//        });

//
//
//        if (_isPulled){
//            for (Tafel tafel : _tafels) {
//                Log.d("TellenTafels", "Tafel: ");
//                _qDrinks = _db.child("Tafel").child(tafel.tafelKey).child("Bestellingen").child("Drinken");
//
//                _qDrinks.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                        if (dataSnapshot.exists()){
//                            for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
//                                String naam = String.valueOf(itemSnapshot.child("naam").getValue());
//                                float prijs = Float.valueOf(String.valueOf(itemSnapshot.child("prijs").getValue()));
//
//                                Drink drink = new Drink(naam, prijs);
//                                _drinks.add(drink);
//                                drinkArrayAdapter.notifyDataSetChanged();
//                            }
//                        }
//                        Log.d("TafelsDrinks", String.valueOf(_drinks));
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
//                    }
//                });
//            }
//        }


//        Log.d("Bar", String.valueOf(_drinks));
//
//
//        Log.d("BarTafelsOnStart", String.valueOf(_tafels));
    }

    @Override
    public void onStart() {
        super.onStart();

        _tafelDrinks = new HashMap<>();

        for (int i = 1; i < 7; i++){

            _qDrinks = _db.child("Tafel").child("Tafel" + i).child("Bestellingen").child("Drinken");
            final ArrayList<Drink> tempList = new ArrayList<>();;
            final int finalI = i;
            _qDrinks.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    if (dataSnapshot.exists()) {

                        String naam = String.valueOf(dataSnapshot.child("naam").getValue());
                        float prijs = Float.valueOf(String.valueOf(dataSnapshot.child("prijs").getValue()));
                        Drink drink = new Drink(naam, prijs);

                        tempList.add(drink);

                        drinkArrayAdapter.notifyDataSetChanged();
                        Log.d("BarTafels", String.valueOf(_drinksT1));
                        Log.d("BarTafels", "tell mij");
                    }
                    _tafelDrinks.put(("Tafel" + finalI), tempList);

                    Log.d("BarTempArrays", String.valueOf(tempList));
                    for (String i : _tafelDrinks.keySet()) {
                        Log.d("BarTafels", "key: " + i + " value: " + _tafelDrinks.get(i));
                    }

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

//        for (int i = 1; i < 7; i++){
//
//            _qDrinks = _db.child("Tafel").child("Tafel" + i).child("Bestellingen").child("Drinken");
//
//            _qDrinks.addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                    if (dataSnapshot.exists()){
//
//                        String naam = String.valueOf(dataSnapshot.child("naam").getValue());
//                        float prijs = Float.valueOf(String.valueOf(dataSnapshot.child("prijs").getValue()));
//                        Drink drink = new Drink(naam, prijs);
//                        _drinksT1.add(drink);
//                        drinkArrayAdapter.notifyDataSetChanged();
//                        Log.d("BarTafels", String.valueOf(_drinksT1));
//                        Log.d("BarTafels", "tell mij");
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }



    }




}
