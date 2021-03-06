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

        calendarFragment = new CalendarFragment();
        getChildFragmentManager().beginTransaction()
        .replace(R.id.frame_calendar, calendarFragment)
        .addToBackStack(null)
        .commit();

        return v;
    }

    @Override
    public void onDateSent(Bundle b) {
        // scheduleViewFragment 에 날짜정보를 보내고 일정화면 열기
        scheduleViewFragment = new ScheduleViewFragment();
        scheduleViewFragment.setArguments(b);
        getChildFragmentManager().beginTransaction()
        .replace(R.id.frame_calendar, scheduleViewFragment, "sch_view")
        .addToBackStack(null)
        .commit();
    }

    @Override
    public void onScheduleSent(Bundle b) {
        getChildFragmentManager().popBackStack();
        scheduleViewFragment.addSchedule(b.getInt("hour"), b.getInt("minute"), b.getString("name"));
    }

    @Override
    public void onAddSent(Bundle b) {
        scheduleSettingFragment = new ScheduleSettingFragment();
        scheduleSettingFragment.setArguments(b);
        getChildFragmentManager().beginTransaction()
        .replace(R.id.frame_calendar, scheduleSettingFragment)
        .addToBackStack(null)
        .commit();
    }

}