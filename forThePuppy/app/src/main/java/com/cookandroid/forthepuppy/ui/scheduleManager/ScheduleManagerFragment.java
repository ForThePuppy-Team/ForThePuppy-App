package com.cookandroid.forthepuppy.ui.scheduleManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.cookandroid.forthepuppy.R;

public class ScheduleManagerFragment extends Fragment implements CalendarFragment.CalendarFragmentListener, ScheduleViewFragment.ScheduleViewFragmentListener, ScheduleSettingFragment.ScheduleSettingFragmentListener{

    private ScheduleSettingFragment scheduleSettingFragment;
    private ScheduleViewFragment scheduleViewFragment;
    private CalendarFragment calendarFragment;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("log_fragment", "스케줄매니저 프래그먼트 생성");
        View v = inflater.inflate(R.layout.fragment_schedule_manager, container, false);

        FragmentTransaction tx = getChildFragmentManager().beginTransaction();
        calendarFragment = new CalendarFragment();
        tx.replace(R.id.frame_calendar, calendarFragment);
        tx.addToBackStack(null);
        tx.commit();

        return v;
    }

    @Override
    public void onDateSent(Bundle b) {
        // scheduleViewFragment 에 날짜정보를 보내고 일정화면 열기
        FragmentTransaction tx = getChildFragmentManager().beginTransaction();
        scheduleViewFragment = new ScheduleViewFragment();
        scheduleViewFragment.setArguments(b);
        tx.replace(R.id.frame_calendar, scheduleViewFragment, "sch_view");
        tx.addToBackStack(null);
        tx.commit();
    }

    @Override
    public void onScheduleSent(Bundle b) {
        getChildFragmentManager().popBackStack();
        scheduleViewFragment.addSchedule(b.getInt("hour"), b.getInt("minute"), b.getString("name"));
    }

    @Override
    public void onAddSent(Bundle b) {
        FragmentTransaction tx = getChildFragmentManager().beginTransaction();
        scheduleSettingFragment = new ScheduleSettingFragment();
        scheduleSettingFragment.setArguments(b);
        tx.replace(R.id.frame_calendar, scheduleSettingFragment);
        tx.addToBackStack(null);
        tx.commit();
    }

}