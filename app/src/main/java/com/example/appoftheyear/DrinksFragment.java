package com.example.appoftheyear;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private ListView menuListView ;
    private ArrayList<String> _drinks;

    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
        _drinks = (ArrayList<String>)getArguments().getSerializable("drinksNamen");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter menuAdapter = new ArrayAdapter<String>(getActivity(), R.layout.menulist_item, _drinks);
        menuListView.setAdapter( menuAdapter );

        return view;
    }

}
