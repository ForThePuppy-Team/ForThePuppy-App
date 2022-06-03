package com.cookandroid.forthepuppy.ui.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.utils.communityUtils.CommunityListItem;
import com.cookandroid.forthepuppy.utils.communityUtils.ListAdapter;

import java.util.List;

public class CommunityBoardFragment extends Fragment {
    private ListView postList;
    private Button btnNewPost;
    private List<CommunityListItem> listItems;
    private ListAdapter adapter = new ListAdapter();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post_list, container, false);
        postList = v.findViewById(R.id.postList);
        btnNewPost = v.findViewById(R.id.btnNewPost);

        postList.setAdapter(adapter);

        btnNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
                // 글쓰기 화면으로 이동
            }
        });
        return v;
    }
}
