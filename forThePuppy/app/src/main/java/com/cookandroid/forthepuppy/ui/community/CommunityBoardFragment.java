package com.cookandroid.forthepuppy.ui.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private CommunityBoardFragmentListener listener = null;

    private ListView postList;
    private Button btnNewPost;
    private List<CommunityListItem> listItems;
    private ListAdapter adapter = new ListAdapter();

    public interface CommunityBoardFragmentListener {
        void onNewPostSent();
        void onReadPostSent(CommunityListItem c);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getParentFragment() instanceof CommunityBoardFragmentListener) {
            listener = (CommunityBoardFragmentListener) getParentFragment();
        } else {
            throw new RuntimeException(getParentFragment().toString() + "must implement CommunityBoardListener");
        }
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

        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CommunityListItem item = (CommunityListItem) adapterView.getItemAtPosition(i);
                listener.onReadPostSent(item);
            }
        });

        btnNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewPostSent();
            }
        });
        return v;
    }

    public void addPost(String title, String body){
        adapter.addItem(title, body);
    }

}
