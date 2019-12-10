package com.example.appoftheyear;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appoftheyear.classLibrary.Hoofdgerecht;
import com.example.appoftheyear.classLibrary.MenuItem;
import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.util.ArrayList;
import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ItemViewHolder> {
    private final ArrayList<Hoofdgerecht> _menuItems;
    private LayoutInflater inflater;

    public MenuListAdapter(Context context, ArrayList<Hoofdgerecht> menuItems) {
        inflater = LayoutInflater.from(context);
        this._menuItems = menuItems;
    }

    @NonNull
    @Override
    public MenuListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.menulist_item, parent, false);
        return new ItemViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MenuItem current = _menuItems.get(position);
        holder.menuItemView.setText(current.Get_naam());
    }

    @Override
    public int getItemCount() {
        return _menuItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView menuItemView;
        final MenuListAdapter adapter;

        public ItemViewHolder(View itemView, MenuListAdapter adapter) {
            super(itemView);
            menuItemView = itemView.findViewById(R.id.menu_item);
            this.adapter = adapter;
        }
    }
}
