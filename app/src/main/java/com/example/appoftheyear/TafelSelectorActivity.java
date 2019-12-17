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

    public ArrayList<Tafel> Tafels;
    private DatabaseReference _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel_selector);

        _db = FirebaseDatabase.getInstance().getReference();

        Tafels = new ArrayList<>();

//        for (int i=1; i < 7; i++){
//            Tafels.add(new Tafel(i));
//        }


        Log.d("Tafels", String.valueOf(Tafels));
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

//                    Log.d("DBTafels", String.valueOf(tafelId));
                    Log.d("DBTafels", String.valueOf(tafel));
                    Log.d("DBTafels", String.valueOf(tafel.tafelId));

                }
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
                intent.putExtra("tafel", Tafels.get(0));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
            case (R.id.Tafel1):
//                generateBundle(1);
                intent.putExtra("tafel", Tafels.get(1));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
            case (R.id.Tafel2):
//                generateBundle(2);
                intent.putExtra("tafel", Tafels.get(2));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
            case (R.id.Tafel3):
//                generateBundle(3);
                intent.putExtra("tafel", Tafels.get(3));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
            case (R.id.Tafel4):
//                generateBundle(4);
                intent.putExtra("tafel", Tafels.get(4));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
            case (R.id.Tafel5):
//                generateBundle(5);
                intent.putExtra("tafel", Tafels.get(5));
                Log.d("Tafels", String.valueOf(Tafels.get(0).tafelId));
                break;
        }
        startActivity(intent);
    }

}
