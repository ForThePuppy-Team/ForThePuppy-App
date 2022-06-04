package com.cookandroid.forthepuppy.ui.scheduleManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.utils.scheduleUtils.ListAdapter;
import com.cookandroid.forthepuppy.utils.scheduleUtils.ScheduleData;

import java.util.List;

public class ScheduleViewFragment extends Fragment {
    private int year, month, dayMonth;
    private ScheduleViewFragmentListener listener = null;

    private TextView textDate;
    private ListView scheduleList;
    private Button btnAdd;
    private List<ScheduleData> listItems;
    private ListAdapter adapter = new ListAdapter();


    public interface ScheduleViewFragmentListener {
        void onAddSent(Bundle b);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getParentFragment() instanceof ScheduleViewFragmentListener) {
            listener = (ScheduleViewFragmentListener) getParentFragment();
        } else {
            throw new RuntimeException(context.toString() + "must implement ScheduleViewFragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        if (data != null) {
            year = data.getInt("year");
            month = data.getInt("month");
            dayMonth = data.getInt("day");

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_schedule_view, container, false);
        textDate = (TextView) v.findViewById(R.id.date);
        textDate.setText(month+"월 "+dayMonth+"일");
        scheduleList = (ListView) v.findViewById(R.id.scheduleList);
        scheduleList.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        btnAdd = (Button) v.findViewById(R.id.btnAddSchedule);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putInt("year", year);
                data.putInt("month", month);
                data.putInt("day", dayMonth);
                listener.onAddSent(data);
            }
        });
        return v;
    }

    public void addSchedule(int hour, int minute, String name){
        adapter.addItem(hour, minute, name);
    }

}
