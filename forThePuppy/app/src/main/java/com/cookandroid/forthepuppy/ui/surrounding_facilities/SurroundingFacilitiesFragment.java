package com.cookandroid.forthepuppy.ui.surrounding_facilities;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;

public class SurroundingFacilitiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_surrounding_facilties, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.surroundingFacilitiesToolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        return view;
    }
}