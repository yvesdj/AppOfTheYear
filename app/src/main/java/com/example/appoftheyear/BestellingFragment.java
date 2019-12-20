package com.example.appoftheyear;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.Tafel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BestellingFragment extends Fragment {

    private DatabaseReference _db;


    private ListView menuListView ;
    private ArrayAdapter<MenuItem> menuAdapter;

    private ArrayList<MenuItem> _eten;
    private ArrayList<MenuItem> _drinken;


    private Tafel _tafel;
    private FloatingActionButton _submitBtn;

    public BestellingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _tafel = getArguments().getParcelable("tafel");
        _db = FirebaseDatabase.getInstance().getReference();
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);

        _submitBtn = ((TafelActivity) getActivity()).getFloatingActionButton();
        if (_submitBtn != null) {
            _submitBtn.show();

            _submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!_eten.isEmpty()){
                        for (MenuItem item : _eten) {
                            writeItemToDB(item, "Eten");
                        }
                    }
                    if (!_drinken.isEmpty()){
                        for (MenuItem item : _drinken) {
                            writeItemToDB(item, "Drinken");
                        }
                    }

                    _eten.clear();
                    _drinken.clear();
                    _tafel.tafelItems.clear();
                    menuListView.setAdapter(null);
                }
            });
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        menuAdapter = new ArrayAdapter<>(getActivity(), R.layout.menulist_item, _tafel.tafelItems);
        menuListView = view.findViewById( R.id.menuListView );
        menuListView.setAdapter( menuAdapter );
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (_submitBtn != null) {
            _submitBtn.show();
        }

        _eten = _tafel.GetEten();
        _drinken = _tafel.GetDrinken();
    }

    private void writeItemToDB(MenuItem item, String category) {
        _db.child("Tafel").child(_tafel.tafelKey).child("Bestellingen").child(category).push().setValue(item);
    }

}
