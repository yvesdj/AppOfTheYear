package com.example.appoftheyear;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Dessert;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DessertFragment extends Fragment {

    private DatabaseReference _db;

    private ListView menuListView ;
//    private ArrayList<String> _desserten;
    private ArrayList<Dessert> _desserten;
    private Tafel _tafel;

    public DessertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);

        _db = FirebaseDatabase.getInstance().getReference();

        _desserten = getArguments().getParcelableArrayList("desserten");
        _tafel = getArguments().getParcelable("tafel");

        menuListView = view.findViewById( R.id.menuListView );

//        ArrayAdapter menuAdapter = new ArrayAdapter<String>(getActivity(), R.layout.menulist_item, _desserten);
        ArrayAdapter<Dessert> menuAdapter = new ArrayAdapter<Dessert>(getActivity(), R.layout.menulist_item, _desserten);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dessert clickedItem =  (Dessert) parent.getItemAtPosition(position);
                addMenuItemToTable(clickedItem);
//                _tafel.AddMenuItem(clickedItem);
            }
        });

        return view;
    }

    private void addMenuItemToTable(MenuItem item){
        _db.child("Tafel").child(_tafel.tafelKey).child("Bestelde Items").push().setValue(item);
    }

}
