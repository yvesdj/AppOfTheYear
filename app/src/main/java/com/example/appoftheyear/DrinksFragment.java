package com.example.appoftheyear;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Drink;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private ListView menuListView ;
    private ArrayList<Drink> _drinks;
    private FloatingActionButton _submitBtn;

    private Tafel _tafel;

    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);

        _submitBtn = ((TafelActivity) getActivity()).getFloatingActionButton();
        if (_submitBtn != null) {
            _submitBtn.hide();
        }

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

    @Override
    public void onResume() {
        super.onResume();
        if (_submitBtn != null) {
            _submitBtn.hide();
        }
    }

}
