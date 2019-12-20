package com.example.appoftheyear;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Dessert;
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

public class BarActivity extends AppCompatActivity {

    private DatabaseReference _db;
    private Query _qDrinks;
    private boolean _isPulled = false;

    private ArrayList<Tafel> _tafels = new ArrayList<>();
    private ArrayList<Drink> _drinksT1 = new ArrayList<>();

    private ListView drinksListView;
    private ArrayAdapter<Drink> drinkArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        _db = FirebaseDatabase.getInstance().getReference();

        drinksListView = findViewById(R.id.drinksListView);
        drinkArrayAdapter = new ArrayAdapter<Drink>(this, R.layout.menulist_item, _drinksT1);
        drinksListView.setAdapter(drinkArrayAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        for (int i = 1; i < 7; i++){

            _qDrinks = _db.child("Tafel").child("Tafel" + i).child("Bestellingen").child("Drinken");

            final int finalI = i;
            _qDrinks.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    if (dataSnapshot.exists()){

                        String naam = String.valueOf(dataSnapshot.child("naam").getValue());
                        float prijs = Float.valueOf(String.valueOf(dataSnapshot.child("prijs").getValue()));
                        Drink drink = new Drink(naam, prijs);

                        drink.dbKey = dataSnapshot.getKey();
                        drink.vanTafel = "Tafel" + finalI;
                        _drinksT1.add(drink);
                        drinkArrayAdapter.notifyDataSetChanged();

                        Log.d("BarTafels", drink.dbKey);
                        Log.d("BarTafels", drink.vanTafel);
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    Log.d("BarTafels", "onChildRemoved: " + dataSnapshot.getKey());


                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        drinksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink clickedItem =  (Drink) parent.getItemAtPosition(position);
                String itemKey = clickedItem.dbKey;
                String tafelKey = clickedItem.vanTafel;
                Log.d("BarTafels", "onItemClick: " + clickedItem.dbKey + clickedItem.vanTafel);
                DeleteItem(itemKey, tafelKey);

                _drinksT1.remove(clickedItem);
                drinkArrayAdapter.notifyDataSetChanged();
            }
        });

    }

    public void DeleteItem(String key, String vanTafel){
        _db.child("Tafel").child(vanTafel).child("Bestellingen").child("Drinken").child(key).removeValue();
    }


}
