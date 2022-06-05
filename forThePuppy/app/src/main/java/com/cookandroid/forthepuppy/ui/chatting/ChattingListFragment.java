package com.cookandroid.forthepuppy.ui.chatting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.api.ApiClientPuppy;
import com.cookandroid.forthepuppy.api.ApiInterfacePuppy;
import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatContentsResult;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatResult;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChattingResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChattingResult;
import com.cookandroid.forthepuppy.model.puppy.chatting.PostChatBody;
import com.cookandroid.forthepuppy.model.puppy.chatting.PostChattingBody;
import com.cookandroid.forthepuppy.utils.chat.ListViewAdapterChat;
import com.cookandroid.forthepuppy.utils.chat.ListViewAdapterChattingList;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChattingListFragment extends Fragment {
    ChatResult chatResult;
    String X_ACCESS_TOKEN;
    int userIdx;

    ListView listview;

    ChattingResult chattingResult;
    List<ChatContentsResult> viewItems;

    // Adapter 생성
    ListViewAdapterChattingList adapter = new ListViewAdapterChattingList();

    EditText sendMss;

    public ChattingListFragment(ChatResult chatResult, String X_ACCESS_TOKEN, int userIdx) {
        this.chatResult = chatResult;
        this.X_ACCESS_TOKEN = X_ACCESS_TOKEN;
        this.userIdx = userIdx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chatting_list, container, false);

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChatContentsResult item = adapter.getItem(i);
//                ((MainActivity)getActivity()).chattingRoom(item);
            }
        });

        // 채팅 내역 불러오기
        callChatting();

        // 일정시간마다 새 메세지 받아오기
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //3초마다 실행
                callChatting();
            }
        };
        timer.schedule(timerTask,0,3000);

        // 메세지 보네기
        sendMss = (EditText) view.findViewById(R.id.sendMss);
        ImageButton btnSend = (ImageButton) view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = sendMss.getText().toString();
                String image = "test";
                sendMss.setText("");
                PostChattingBody postChattingBody = new PostChattingBody(message,image,chattingResult.getUserIdx(),userIdx);

                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.postChatting(X_ACCESS_TOKEN, postChattingBody,chattingResult.getRoomIdx());
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("postChatting 실패", response.toString());
                            Toast.makeText(getContext(),"메세지 전송 실패",Toast.LENGTH_SHORT).show();
                            ((MainActivity)getActivity()).viewChangeChatting();
                            return;
                        }

                        BasicResponse postChattingResponse = response.body();
                        String content = "";
                        content += postChattingResponse.getMessage();
                        Log.d("postChatting", postChattingResponse.getMessage());
                        callChatting();
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

    public void callChatting() {
        // 채팅내역 불러오기
        ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
        Call<ChattingResponse> call = apiInterfacePuppy.getChattingList(X_ACCESS_TOKEN, userIdx,chatResult.getRoomIdx());
//        Call<ChattingResponse> call = apiInterfacePuppy.getChattingList("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM3MjE1NjIsImV4cCI6MTY1NTE5Mjc5MX0.pOEH_9Ejdv63Yn7_agRmzHqBOUgnzX2rTG4TbI7RWz4", 1,3);
        call.enqueue(new Callback<ChattingResponse>() {
            @Override
            public void onResponse(Call<ChattingResponse> call, Response<ChattingResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d("postChats 실패", response.toString());
                    Toast.makeText(getContext(),"메세지 전송 실패",Toast.LENGTH_SHORT).show();
                    ((MainActivity)getActivity()).viewChangeChatting();
                    return;
                }

                ChattingResponse getChatting = response.body();
                Log.d("getChatting", getChatting.getMessage());
                chattingResult = getChatting.getChattingResult().get(0);
                if (chattingResult != null) {
                    viewItems = chattingResult.getChatContents();

                    adapter.setChattingResult(chattingResult);
                    setViewItems(viewItems);
                }
            }

            @Override
            public void onFailure(Call<ChattingResponse> call, Throwable t) {

            }
        });
    }

    public void setViewItems(List<ChatContentsResult> viewItems) {
        this.viewItems = viewItems;
        adapter.clear();
        for (ChatContentsResult d : viewItems) {
            adapter.addItem(d);
        }

        adapter.notifyDataSetChanged(); // 리스트 목록 갱신
        listview.setSelection(adapter.getCount() - 1);
    }
}