package com.example.appoftheyear;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.Tafel;
import com.example.appoftheyear.classLibrary.Voorgerecht;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoorgerechtenFragment extends Fragment {

    private ListView menuListView ;
    private ArrayList<Voorgerecht> _voorgerechten;
    private Tafel _tafel;
    private FloatingActionButton _submitBtn;


    public VoorgerechtenFragment() {
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
        _voorgerechten = getArguments().getParcelableArrayList("voorgerechten");
        _tafel = getArguments().getParcelable("tafel");

        _submitBtn = ((TafelActivity) getActivity()).getFloatingActionButton();
        if (_submitBtn != null) {
            _submitBtn.hide();
        }

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

    @Override
    public void onResume() {
        super.onResume();
        if (_submitBtn != null) {
            _submitBtn.hide();
        }
    }

}
