package com.cookandroid.forthepuppy.ui.community;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.R;

public class CommunityFragment extends Fragment {

//    todo
//     글쓰기, 글 보기 프래그먼트를 변수로 추가
    private CommunityBoardFragment communityBoardFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);

        FragmentTransaction tx = getChildFragmentManager().beginTransaction();
        communityBoardFragment = new CommunityBoardFragment();
        tx.replace(R.id.frame_community, communityBoardFragment, "ListViewPost");
        tx.commit();

        return v;
    }
}