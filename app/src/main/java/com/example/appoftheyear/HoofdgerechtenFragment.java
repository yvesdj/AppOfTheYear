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
import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.Tafel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HoofdgerechtenFragment extends Fragment {

    private ListView menuListView ;
//    private ArrayList<String> _hoofdgerechten;
    private ArrayList<Hoofdgerecht> _hoofdgerechten;
    private Tafel _tafel;

    public HoofdgerechtenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
//        _hoofdgerechten = (ArrayList<String>)getArguments().getSerializable("hoofdgerechtNamen");
        _hoofdgerechten = getArguments().getParcelableArrayList("hoofdgerechten");
        _tafel = getArguments().getParcelable("tafel");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter<Hoofdgerecht> menuAdapter = new ArrayAdapter<Hoofdgerecht>(getActivity(), R.layout.menulist_item, _hoofdgerechten);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hoofdgerecht clickedItem =  (Hoofdgerecht) parent.getItemAtPosition(position);

                _tafel.AddMenuItem(clickedItem);
            }
        });

        return view;
    }

}
