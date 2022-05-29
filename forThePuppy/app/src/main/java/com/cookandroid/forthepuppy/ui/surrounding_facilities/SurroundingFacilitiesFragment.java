package com.cookandroid.forthepuppy.ui.surrounding_facilities;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SurroundingFacilitiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surrounding_facilties, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.surroundingFacilitiesToolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        ViewPager vp = (ViewPager) view.findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapter);

        // 탭바랑 연동
        TabLayout tab = (TabLayout) view.findViewById(R.id.sf_tab);
        tab.setupWithViewPager(vp);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.ic_baseline_home_24);
        images.add(R.drawable.ic_baseline_person_24);
        images.add(R.drawable.ic_baseline_forum_24);

        for (int i = 0; i < 3; i++) tab.getTabAt(i).setIcon(images.get(i));
        return view;
    }
}