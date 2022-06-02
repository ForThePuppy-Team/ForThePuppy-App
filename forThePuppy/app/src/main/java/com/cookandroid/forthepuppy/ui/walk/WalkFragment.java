package com.cookandroid.forthepuppy.ui.walk;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.ui.surrounding_facilities.VPAdapter_sf;
import com.google.android.material.tabs.TabLayout;

public class WalkFragment extends Fragment {
    VPAdapter_walk adapter;

    int userIdx;
    int puppyIdx;
    String X_ACCESS_TOKEN;

    public WalkFragment(int userIdx, int puppyIdx, String x_ACCESS_TOKEN) {
        this.userIdx = userIdx;
        this.puppyIdx = puppyIdx;
        X_ACCESS_TOKEN = x_ACCESS_TOKEN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_walk, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.walkToolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        ViewPager vp = (ViewPager) view.findViewById(R.id.viewpager_walk);
        adapter = new VPAdapter_walk(getActivity().getSupportFragmentManager(),userIdx,puppyIdx,X_ACCESS_TOKEN);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(3); // fragment 상태유지 하는 개수

        // 탭바랑 연동
        TabLayout tab = (TabLayout) view.findViewById(R.id.walk_tab);
        tab.setupWithViewPager(vp);

        return view;
    }

    public void refreshDailyList(){
        adapter.refreshDailyList();
    }
}