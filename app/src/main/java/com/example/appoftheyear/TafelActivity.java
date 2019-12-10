package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.MenuKaart;
import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.util.ArrayList;
import java.util.LinkedList;

public class TafelActivity extends AppCompatActivity {

//    private final LinkedList<Voorgerecht> voorgerechten = new LinkedList<>();
    private MenuKaart menuKaart;
    private RecyclerView recyclerView;
    private MenuListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel);

        menuKaart = new MenuKaart();
        ArrayList<Hoofdgerecht> hoofdgerechten= menuKaart.GetHoofdgerechten();

//        for (int i = 0; i < 20; i++) {
//            String naam = "voorgerecht " + i;
//            voorgerechten.addLast(new Voorgerecht(naam , 4));
//            Log.d("Voorgerechten", "Value: " + naam);
//
//        }
//        Voorgerecht voorgerecht2 = voorgerechten.get(1);
//        Log.d("Voorgerechten", "Value: " + voorgerecht2);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MenuListAdapter(this, hoofdgerechten);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
