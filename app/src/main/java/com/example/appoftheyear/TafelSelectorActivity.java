package com.example.appoftheyear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TafelSelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tafel_selector);
    }

    public void GaNaarTafel(View view) {
        Intent intent = new Intent(this, TafelActivity.class);
        startActivity(intent);
    }

}
