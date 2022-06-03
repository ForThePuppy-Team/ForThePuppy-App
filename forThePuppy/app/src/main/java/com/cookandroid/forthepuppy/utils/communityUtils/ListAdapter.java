package com.cookandroid.forthepuppy.utils.communityUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.utils.scheduleUtils.ScheduleData;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private ArrayList<CommunityListItem> listItems = new ArrayList<>();

    @Override
    public int getCount() { return listItems.size(); }

    @Override
    public Object getItem(int position) { return listItems.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final Context context = parent.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.community_list_item, parent, false);

            TextView title = view.findViewById(R.id.communityItemTitle);
            TextView author = view.findViewById(R.id.communityItemAuthor);
            TextView region = view.findViewById(R.id.communityItemRegion);
            TextView date = view.findViewById(R.id.communityItemDate);
            CommunityListItem listItem = listItems.get(position);
            title.setText(listItem.getTitle());
        }
        return view;
    }

    public void addItem(String title) {
        CommunityListItem item = new CommunityListItem(title);
        listItems.add(listItems.size(), item);
        notifyDataSetChanged();
    }

}
