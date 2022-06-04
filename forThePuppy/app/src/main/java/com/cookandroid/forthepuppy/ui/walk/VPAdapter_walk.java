package com.cookandroid.forthepuppy.ui.walk;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter_walk extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<>();

    public VPAdapter_walk(FragmentManager fm, int userIdx, int puppyIdx, String X_ACCESS_TOKEN){
        super(fm);
        items = new ArrayList<>();
        items.add(new FragmentWalkSelf(userIdx, puppyIdx, X_ACCESS_TOKEN));
        items.add(new FragmentWalkSubstitute());
        items.add(new FragmentWalkDailyRecord(X_ACCESS_TOKEN,userIdx));

        itext.add("산책하기");
        itext.add("대리산책");
        itext.add("산책일지");
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
    
    // 새 산책이 등록되면 일지 갱신
    public void refreshDailyList(){
        for (Fragment i : items){
            if (i instanceof FragmentWalkDailyRecord){
                ((FragmentWalkDailyRecord) i).setWalkData();
            }
        }
    }
    
}
