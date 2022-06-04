package com.cookandroid.forthepuppy.utils.scheduleUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.cookandroid.forthepuppy.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private ArrayList<ScheduleData> listData = new ArrayList<>();

    public ListAdapter(){

    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.schedule_list_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView hour = (TextView) convertView.findViewById(R.id.scheduleItemHour);
        TextView minute = (TextView) convertView.findViewById(R.id.scheduleItemMinute);
        TextView name = (TextView) convertView.findViewById(R.id.scheduleItemName);
        Button btnEdit = (Button) convertView.findViewById(R.id.btnScheduleItemEdit);
        Button btnDel = (Button) convertView.findViewById(R.id.btnScheduleItemDel);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //일정 수정, ScheduleSettingFragment
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //일정 삭제
                listData.remove(position);
                notifyDataSetChanged();
            }
        });

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ScheduleData listItem = listData.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        hour.setText(Integer.toString(listItem.getHour()));
        minute.setText(Integer.toString(listItem.getMinute()));
        name.setText(listItem.getName());

        return convertView;
    }

    public void notifyDataSetChanged() { super.notifyDataSetChanged();}

    public void addItem(int hour, int minute, String name) {
        ScheduleData sd = new ScheduleData(hour, minute, name);
        listData.add(listData.size(), sd);
        notifyDataSetChanged();
    }

}
