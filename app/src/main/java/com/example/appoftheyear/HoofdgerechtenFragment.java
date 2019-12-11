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
public class HoofdgerechtenFragment extends Fragment {

    private ListView menuListView ;
    private ArrayList<String> _hoofdgerechten;

    public HoofdgerechtenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
        _hoofdgerechten = (ArrayList<String>)getArguments().getSerializable("hoofdgerechtNamen");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter menuAdapter = new ArrayAdapter<String>(getActivity(), R.layout.menulist_item, _hoofdgerechten);
        menuListView.setAdapter( menuAdapter );

        return view;
    }

}
