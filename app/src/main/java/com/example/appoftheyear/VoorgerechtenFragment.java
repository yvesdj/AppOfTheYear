package com.example.appoftheyear;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.Tafel;
import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoorgerechtenFragment extends Fragment {

    private ListView menuListView ;
//    private ArrayList<String> _voorgerechten;
    private ArrayList<Voorgerecht> _voorgerechten;
    private Tafel _tafel;


    public VoorgerechtenFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
        _voorgerechten = getArguments().getParcelableArrayList("voorgerechten");
        _tafel = getArguments().getParcelable("tafel");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter<Voorgerecht> menuAdapter = new ArrayAdapter<Voorgerecht>(getActivity(), R.layout.menulist_item, _voorgerechten);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Voorgerecht clickedItem =  (Voorgerecht) parent.getItemAtPosition(position);

                _tafel.AddMenuItem(clickedItem);
            }
        });

        return view;
    }

}
