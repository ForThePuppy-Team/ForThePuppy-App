package com.cookandroid.forthepuppy.ui.walk;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;

public class WalkFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_walk, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.walkToolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        return view;
    }
}