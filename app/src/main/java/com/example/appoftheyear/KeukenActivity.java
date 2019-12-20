package com.example.appoftheyear;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.MenuItem;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KeukenActivity extends AppCompatActivity {

    private DatabaseReference _db;
    private Query _qEten;

    private ArrayList<MenuItem> _eten = new ArrayList<>();

    private ListView etenListView;
    private ArrayAdapter<MenuItem> etenArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuken);

        _db = FirebaseDatabase.getInstance().getReference();

        etenListView = findViewById(R.id.etenListView);
        etenArrayAdapter = new ArrayAdapter<>(this, R.layout.menulist_item, _eten);
        etenListView.setAdapter(etenArrayAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();

        for (int i = 1; i < 7; i++){

            _qEten = _db.child("Tafel").child("Tafel" + i).child("Bestellingen").child("Eten");

            final int finalI = i;
            _qEten.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    if (dataSnapshot.exists()){

                        String naam = String.valueOf(dataSnapshot.child("naam").getValue());
                        float prijs = Float.valueOf(String.valueOf(dataSnapshot.child("prijs").getValue()));
                        MenuItem item = new MenuItem(naam, prijs);

                        item.dbKey = dataSnapshot.getKey();
                        item.vanTafel = "Tafel" + finalI;
                        _eten.add(item);
                        etenArrayAdapter.notifyDataSetChanged();
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

        etenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuItem clickedItem =  (MenuItem) parent.getItemAtPosition(position);
                String itemKey = clickedItem.dbKey;
                String tafelKey = clickedItem.vanTafel;
                DeleteItem(itemKey, tafelKey);

                _eten.remove(clickedItem);
                etenArrayAdapter.notifyDataSetChanged();
            }
        });

    }

    public void DeleteItem(String key, String vanTafel){
        _db.child("Tafel").child(vanTafel).child("Bestellingen").child("Eten").child(key).removeValue();
    }
}
