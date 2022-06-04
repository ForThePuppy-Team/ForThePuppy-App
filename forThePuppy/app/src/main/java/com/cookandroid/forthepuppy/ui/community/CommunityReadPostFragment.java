package com.cookandroid.forthepuppy.ui.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.forthepuppy.R;

public class CommunityReadPostFragment extends Fragment {
    private String title, body;

    TextView tvTitle, tvBody;
    Button btnSend;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        if (data != null) {
            title = data.getString("title");
            body = data.getString("body");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_read_post, container, false);

        tvTitle = (TextView) v.findViewById(R.id.postTitle);
        tvBody = (TextView) v.findViewById(R.id.postBody);

        tvTitle.setText(title);
        tvBody.setText(body);

        btnSend = (Button) v.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                todo:
//                 신청 전송
            }
        });

        return v;
    }
}
