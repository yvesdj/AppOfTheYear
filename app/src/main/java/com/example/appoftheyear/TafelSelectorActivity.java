package com.example.appoftheyear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appoftheyear.classLibrary.Tafel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TafelSelectorActivity extends AppCompatActivity {

    private ArrayList<Tafel> _tafels;
    private DatabaseReference _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel_selector);

        _db = FirebaseDatabase.getInstance().getReference();

        _tafels = new ArrayList<>();

//        for (int i=1; i < 7; i++){
//            Tafels.add(new Tafel(i));
//        }


        Log.d("Tafels", String.valueOf(_tafels));
    }

    @Override
    public void onStart() {
        super.onStart();

        Query qTafels = _db.child("Tafel");

        qTafels.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot tafelSnapshot : dataSnapshot.getChildren()){
                    int tafelId = Integer.valueOf(String.valueOf(tafelSnapshot.child("tafelId").getValue())) ;
                    Tafel tafel = new Tafel(tafelId);

                    _tafels.add(tafel);
                }
                Log.d("DBTafels", String.valueOf(_tafels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("DBTest", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }

    public void GaNaarTafel(View view) {
        Intent intent = new Intent(this, TafelActivity.class);
        switch (view.getId()){
            case (R.id.Tafel0):
//                generateBundle(0);
                intent.putExtra("tafel", _tafels.get(0));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
            case (R.id.Tafel1):
//                generateBundle(1);
                intent.putExtra("tafel", _tafels.get(1));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
            case (R.id.Tafel2):
//                generateBundle(2);
                intent.putExtra("tafel", _tafels.get(2));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
            case (R.id.Tafel3):
//                generateBundle(3);
                intent.putExtra("tafel", _tafels.get(3));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
            case (R.id.Tafel4):
//                generateBundle(4);
                intent.putExtra("tafel", _tafels.get(4));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
            case (R.id.Tafel5):
//                generateBundle(5);
                intent.putExtra("tafel", _tafels.get(5));
                Log.d("Tafels", String.valueOf(_tafels.get(0).tafelId));
                break;
        }
        startActivity(intent);
    }

}
