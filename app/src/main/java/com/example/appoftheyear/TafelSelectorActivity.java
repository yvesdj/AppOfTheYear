package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appoftheyear.classLibrary.Tafel;

import java.util.ArrayList;

public class TafelSelectorActivity extends AppCompatActivity {

    public ArrayList<Tafel> Tafels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel_selector);

        Tafels = new ArrayList<>();
        for (int i=0; i < 6; i++){
            Tafels.add(new Tafel(i));
        }
        Log.d("Tafels", String.valueOf(Tafels));
    }

//    private Bundle generateBundle(int tafelsIndex){
//        Bundle args = new Bundle();
//        Tafel tafel = Tafels.get(tafelsIndex);
//        args.putParcelable("tafel", tafel);
//
//        return args;
//    }

    public void GaNaarTafel(View view) {
        Intent intent = new Intent(this, TafelActivity.class);
        switch (view.getId()){
            case (R.id.Tafel0):
//                generateBundle(0);
                intent.putExtra("tafel", Tafels.get(0));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
            case (R.id.Tafel1):
//                generateBundle(1);
                intent.putExtra("tafel", Tafels.get(1));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
            case (R.id.Tafel2):
//                generateBundle(2);
                intent.putExtra("tafel", Tafels.get(2));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
            case (R.id.Tafel3):
//                generateBundle(3);
                intent.putExtra("tafel", Tafels.get(3));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
            case (R.id.Tafel4):
//                generateBundle(4);
                intent.putExtra("tafel", Tafels.get(4));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
            case (R.id.Tafel5):
//                generateBundle(5);
                intent.putExtra("tafel", Tafels.get(5));
                Log.d("Tafels", String.valueOf(Tafels.get(0).Get_tafelId()));
                break;
        }
        startActivity(intent);
    }

}
