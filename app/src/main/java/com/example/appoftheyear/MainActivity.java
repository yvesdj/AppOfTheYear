package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GaNaarBar(View view) {
        Intent intent = new Intent(this, BarActivity.class);
        startActivity(intent);



    }

    public void GaNaarKeuken(View view) {
        Intent intent = new Intent(this, KeukenActivity.class);
        startActivity(intent);
    }

    public void GaNaarTafelSector(View view) {
        Intent intent = new Intent(this, TafelSelectorActivity.class);
        startActivity(intent);
    }
}
