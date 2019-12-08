package com.example.appoftheyear;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private final ArrayList<String> fragmentTile = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    public void addFragement(Fragment fragment, String title){
        fragmentsList.add(fragment);
        fragmentTile.add(title);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTile.get(position);
    }
}
