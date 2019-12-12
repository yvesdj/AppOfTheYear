package com.example.appoftheyear;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoorgerechtenFragment extends Fragment {

    String items[] = new String[] {"Snoekbaars", "Zeevruchten", "Cul noir varken ","Bospaddenstoel", "St-Jacobsoester"};

    public VoorgerechtenFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voorgerechten, container, false);

        ListView listview = (ListView)view.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        listview.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;



    }

}
