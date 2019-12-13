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

import com.example.appoftheyear.classLibrary.Drink;
import com.example.appoftheyear.classLibrary.Tafel;
import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private ListView menuListView ;
//    private ArrayList<String> _drinks;
    private ArrayList<Drink> _drinks;
    private Tafel _tafel;

    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
        _drinks = getArguments().getParcelableArrayList("drinks");
        _tafel = getArguments().getParcelable("tafel");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter<Drink> menuAdapter = new ArrayAdapter<Drink>(getActivity(), R.layout.menulist_item, _drinks);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drink clickedItem =  (Drink) parent.getItemAtPosition(position);

                _tafel.AddMenuItem(clickedItem);
            }
        });

        return view;
    }



}
