package com.cookandroid.forthepuppy.ui.chatting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.api.ApiClientPuppy;
import com.cookandroid.forthepuppy.api.ApiInterfacePuppy;
import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.PostChatBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatCreateFragment extends Fragment {

    String X_ACCESS_TOKEN;

    int senderIdx, receiverIdx;
    String content;

    EditText sendMss;
    public ChatCreateFragment(String x_ACCESS_TOKEN, int senderIdx, int receiverIdx) {
        X_ACCESS_TOKEN = x_ACCESS_TOKEN;
        this.senderIdx = senderIdx;
        this.receiverIdx = receiverIdx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_create, container, false);

        sendMss = (EditText) view.findViewById(R.id.sendMss);

        ImageButton btnSend = (ImageButton) view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = sendMss.getText().toString();
                PostChatBody postChatBody = new PostChatBody(senderIdx,receiverIdx,content);

                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.postChats(X_ACCESS_TOKEN, postChatBody);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("postChats 실패", response.toString());
                            Toast.makeText(getContext(),"메세지 전송 실패",Toast.LENGTH_SHORT).show();
                            ((MainActivity)getActivity()).viewChangeChatting();
                            return;
                        }

                        BasicResponse postWalk = response.body();
                        String content = "";
                        content += postWalk.getMessage();
                        Log.d("postChats", postWalk.getMessage());

                        ((MainActivity)getActivity()).viewChangeChatting();
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }
}