package com.cookandroid.forthepuppy.ui.surrounding_facilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    public VPAdapter(FragmentManager fm){
        super(fm);
        items = new ArrayList<>();
        items.add(new fragment_sf_tab1());
        items.add(new fragment_sf_tab2());
        items.add(new fragment_sf_tab3());

        itext.add("병원");
        itext.add("애견카페");
        itext.add("애견호텔");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
