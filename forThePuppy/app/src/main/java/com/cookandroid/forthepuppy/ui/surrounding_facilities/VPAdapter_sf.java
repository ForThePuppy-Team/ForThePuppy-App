package com.cookandroid.forthepuppy.ui.surrounding_facilities;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.cookandroid.forthepuppy.model.kakao.category_search.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VPAdapter_sf extends FragmentPagerAdapter {
    public ArrayList<fragment_sf_tab> fragments;
    private ArrayList<String> itext = new ArrayList<>();
    private Double Lat = 37.51960712639453;
    private Double Lng = 126.88948858206284;

    public void setLatLng(double Lat, double Lng){
        this.Lat = Lat;
        this.Lng = Lng;
    }

    public VPAdapter_sf(FragmentManager fm){
        super(fm);
        fragments = new ArrayList<>();
        for (int i =0; i< 3 ; i++){
            fragments.add(new fragment_sf_tab());
        }

        itext.add("병원");
        itext.add("애견카페");
        itext.add("애견호텔");
    }

    public void setSfListViewItem(List<Document> items, int n) {
        Collections.sort(items, (a,b) -> (int)(Double.parseDouble(a.getDistance()) * 100) - (int)(Double.parseDouble(b.getDistance()) * 100));
        switch (n){
            case 1:
                fragments.get(0).setViewItems(items, Lat, Lng);
                break;
            case 2:
                fragments.get(1).setViewItems(items, Lat, Lng);
                break;
            case 3:
                fragments.get(2).setViewItems(items, Lat, Lng);
                break;
        }
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
