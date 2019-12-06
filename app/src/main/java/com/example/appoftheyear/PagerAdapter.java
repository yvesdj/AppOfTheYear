package com.example.appoftheyear;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new MenuTabVoorgerechten();
            case 1: return new MenuTabHoofdgerechten();
            case 2: return new MenuTabDesserten();
            case 3: return new MenuTabDrinks();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return this.numOfTabs;
    }
}
