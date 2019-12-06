package com.example.appoftheyear;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appoftheyear.classLibrary.Voorgerecht;

import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ItemViewHolder> {
    private final LinkedList<Voorgerecht> voorgerechten;
    private LayoutInflater inflater;

    public MenuListAdapter(Context context, LinkedList<Voorgerecht> voorgerechten) {
        inflater = LayoutInflater.from(context);
        this.voorgerechten = voorgerechten;
    }

    @NonNull
    @Override
    public MenuListAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.menulist_item, parent, false);
        return new ItemViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Voorgerecht current = voorgerechten.get(position);
        holder.menuItemView.setText(current.Get_naam());
    }

    @Override
    public int getItemCount() {
        return voorgerechten.size();
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
