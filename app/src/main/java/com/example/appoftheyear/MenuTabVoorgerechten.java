package com.example.appoftheyear;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuTabVoorgerechten extends Fragment {
    private final LinkedList<Voorgerecht> voorgerechten = new LinkedList<>();
    private RecyclerView recyclerView;
    private MenuListAdapter adapter;

    public MenuTabVoorgerechten() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_tab_voorgerechten, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        adapter = new MenuListAdapter(this, voorgerechten);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
