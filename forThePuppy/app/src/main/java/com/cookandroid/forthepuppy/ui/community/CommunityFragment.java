package com.cookandroid.forthepuppy.ui.community;

import static com.cookandroid.forthepuppy.ui.community.CommunityBoardFragment.*;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.ui.community.CommunityNewPostFragment.CommunityNewPostFragmentListener;
import com.cookandroid.forthepuppy.utils.communityUtils.CommunityListItem;

public class CommunityFragment extends Fragment implements CommunityBoardFragmentListener, CommunityNewPostFragmentListener {

    private CommunityBoardFragment boardFragment;
    private CommunityNewPostFragment newPostFragment;
    private CommunityReadPostFragment readPostFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_community, container, false);

        boardFragment = new CommunityBoardFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_community, boardFragment, "ListViewPost")
                .commit();

        return v;
    }

    public void onNewPostSent() {
        newPostFragment = new CommunityNewPostFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_community, newPostFragment)
                .addToBackStack(null)
                .commit();

    }

    public void onPostSent(Bundle b) {
        getChildFragmentManager().popBackStack();
        boardFragment.addPost(b.getString("title"), b.getString("body"));
    }

    @Override
    public void onReadPostSent(CommunityListItem c) {
        Bundle b = new Bundle();
        b.putString("title", c.getTitle());
        b.putString("body", c.getBody());
        readPostFragment = new CommunityReadPostFragment();
        readPostFragment.setArguments(b);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_community, readPostFragment)
                .addToBackStack(null)
                .commit();

    }
}