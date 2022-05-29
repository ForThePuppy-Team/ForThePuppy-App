package com.cookandroid.forthepuppy.ui.surrounding_facilities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.cookandroid.forthepuppy.R;

public class fragment_sf_tab1 extends Fragment {
    private ImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sf_tab1, container, false);

        Button btn = view.findViewById(R.id.tempBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KakaoMap.class);
                startActivity(intent);
            }
        });

        Button btn2 = view.findViewById(R.id.tempBtn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KakaoMap.class);
                startActivity(intent);
            }
        });

        return view;
    }
}