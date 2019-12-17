package com.example.appoftheyear;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Dessert;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.Tafel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestellingFragment extends Fragment {

    private ListView menuListView ;
//    private ArrayList<String> _besteldeItems;
    private ArrayList<MenuItem> _besteldeItems;
    private Tafel _tafel;

    public BestellingFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
//        _besteldeItems = (ArrayList<String>)getArguments().getSerializable("besteldeItems");
        _tafel = getArguments().getParcelable("tafel");
        _besteldeItems = _tafel.tafelItems;

        menuListView = view.findViewById( R.id.menuListView );

//        ArrayAdapter menuAdapter = new ArrayAdapter<String>(getActivity(), R.layout.menulist_item, _besteldeItems);
        ArrayAdapter<MenuItem> menuAdapter = new ArrayAdapter<MenuItem>(getActivity(), R.layout.menulist_item, _besteldeItems);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String)parent.getItemAtPosition(position);
                Log.d("ItemClick", clickedItem);

            }
        });

        return view;
    }

}
