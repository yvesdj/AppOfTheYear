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

import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.Tafel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DessertFragment extends Fragment {

    private ListView menuListView ;
    private ArrayList<String> _desserten;
    private Tafel _tafel;

    public DessertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);
        _desserten = (ArrayList<String>)getArguments().getSerializable("dessertNamen");
        _tafel = getArguments().getParcelable("tafel");

        menuListView = view.findViewById( R.id.menuListView );

        ArrayAdapter menuAdapter = new ArrayAdapter<String>(getActivity(), R.layout.menulist_item, _desserten);
        menuListView.setAdapter( menuAdapter );

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String)parent.getItemAtPosition(position);
                Log.d("ItemClick", clickedItem);
                _tafel.AddMenuItem(new MenuItem(clickedItem, 0)); //Solidify

            }
        });

        return view;
    }

}
