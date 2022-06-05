package com.cookandroid.forthepuppy.utils.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatContentsResult;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChattingResult;

import java.util.ArrayList;

public class ListViewAdapterChattingList extends BaseAdapter {

    ChattingResult chattingResult;

    public void setChattingResult(ChattingResult chattingResult) {
        this.chattingResult = chattingResult;
    }

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ChatContentsResult> listViewItemList = new ArrayList<ChatContentsResult>() ;

    // ListViewAdapterChat 생성자
    public ListViewAdapterChattingList() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public ChatContentsResult getItem(int position) {
        return listViewItemList.get(position) ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_chatting_list_item, parent, false);
        }
        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView MessageReceiver = (TextView) convertView.findViewById(R.id.MessageReceiver);
        TextView TimeReceiver = (TextView) convertView.findViewById(R.id.TimeReceiver);
        TextView MessageSend = (TextView) convertView.findViewById(R.id.MessageSend);
        TextView TimeSend = (TextView) convertView.findViewById(R.id.TimeSend);

        LinearLayout receiver = (LinearLayout) convertView.findViewById(R.id.receiver);
        LinearLayout send = (LinearLayout) convertView.findViewById(R.id.send);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ChatContentsResult listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        if (chattingResult.getUserIdx() != listViewItem.getSenderIdx()){
            receiver.setVisibility(View.GONE);
            MessageSend.setText(listViewItem.getMessage());
            TimeSend.setText(listViewItem.getTime());
        }
        else {
            send.setVisibility(View.GONE);
            MessageReceiver.setText(listViewItem.getMessage());
            TimeReceiver.setText(listViewItem.getTime());
        }

        return convertView;
    }
    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(ChatContentsResult item) {
          listViewItemList.add(item);
    }

    public void clear(){
        listViewItemList.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
