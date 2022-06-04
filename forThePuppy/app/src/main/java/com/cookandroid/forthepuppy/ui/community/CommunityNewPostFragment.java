package com.cookandroid.forthepuppy.ui.community;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.ui.scheduleManager.ScheduleViewFragment;

public class CommunityNewPostFragment extends Fragment {
    private CommunityNewPostFragmentListener listener = null;

    EditText postTitle, postBody;
    Button btnSave;


    public interface CommunityNewPostFragmentListener {
        void onPostSent(Bundle b);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getParentFragment() instanceof CommunityNewPostFragmentListener) {
            listener = (CommunityNewPostFragmentListener) getParentFragment();
        } else {
            throw new RuntimeException(context.toString() + "must implement CommunityNewPostFragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_post, container, false);
        postTitle = (EditText) v.findViewById(R.id.newPostTitle);
        postBody = (EditText) v.findViewById(R.id.newPostBody);
        btnSave = (Button) v.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("title", postTitle.getText().toString());
                data.putString("body", postBody.getText().toString());
                listener.onPostSent(data);
            }
        });
        return v;
    }
}
