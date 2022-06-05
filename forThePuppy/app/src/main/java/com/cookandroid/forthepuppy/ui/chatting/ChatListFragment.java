package com.cookandroid.forthepuppy.ui.chatting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.api.ApiClientPuppy;
import com.cookandroid.forthepuppy.api.ApiInterfacePuppy;
import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatResult;
import com.cookandroid.forthepuppy.model.puppy.walk.WalkResponse;
import com.cookandroid.forthepuppy.utils.chat.ListViewAdapterChat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatListFragment extends Fragment {
    List<ChatResult> viewItems;
    ListView listview;

    // Adapter 생성
    ListViewAdapterChat adapter = new ListViewAdapterChat();

    int userIdx;
    String X_ACCESS_TOKEN;

    public ChatListFragment(int userIdx, String x_ACCESS_TOKEN) {
        this.userIdx = userIdx;
        X_ACCESS_TOKEN = x_ACCESS_TOKEN;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listView);
        listview.setAdapter(adapter);

        // 목록 불러오기
        ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
        Call<ChatResponse> call = apiInterfacePuppy.getChatList(X_ACCESS_TOKEN, userIdx);
        call.enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("getChats 실패", response.toString());
                    Toast.makeText(getContext(),"채팅목록 불러오기 실패",Toast.LENGTH_SHORT).show();
                    return;
                }

                ChatResponse postChat = response.body();
                String content = "";
                content += postChat.getMessage();
                Log.d("getChats", postChat.getMessage());

                setViewItems(postChat.getChatResults());
            }

            @Override
            public void onFailure(Call<ChatResponse> call, Throwable t) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChatResult item = adapter.getItem(i);
                ((MainActivity)getActivity()).chattingRoom(item,userIdx);
            }
        });


        return view;
    }

    public void setViewItems(List<ChatResult> viewItems) {
        this.viewItems = viewItems;
        adapter.clear();
        for (ChatResult d : viewItems) {
            adapter.addItem(d);
        }

        adapter.notifyDataSetChanged(); // 리스트 목록 갱신
    }
}