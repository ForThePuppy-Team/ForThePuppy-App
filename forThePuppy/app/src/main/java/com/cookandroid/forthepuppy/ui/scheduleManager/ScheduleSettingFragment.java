package com.cookandroid.forthepuppy.ui.scheduleManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cookandroid.forthepuppy.R;

public class ScheduleSettingFragment extends Fragment {
    private int year, month, day;
    private String repeatSelected = null, noticeSelected = null;
    private TextView txtDate;
    private EditText txtName;
    private TimePicker tPicker;
    private RadioGroup rdoRepeatGroup, rdoNoticeGroup;
    private RadioButton rdoRepeatPicked, rdoNoticePicked;
    private ScheduleSettingFragmentListener listener = null;

    private Button btnSave;

    public interface ScheduleSettingFragmentListener {
        void onScheduleSent(Bundle b);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getParentFragment() instanceof ScheduleSettingFragmentListener) {
            listener = (ScheduleSettingFragmentListener) getParentFragment();
        } else {
            throw new RuntimeException(context.toString() + "must implement ScheduleSettingFragmentListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        if (data != null) {
            year = data.getInt("year");
            month = data.getInt("month");
            day = data.getInt("day");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_schedule_setting, container, false);
        txtDate = (TextView) v.findViewById(R.id.date);
        txtDate.setText(month+"월 "+day+"일");
        txtName = (EditText) v.findViewById(R.id.txtName);
        tPicker = (TimePicker) v.findViewById(R.id.timePicker);
        rdoRepeatGroup = (RadioGroup) v.findViewById(R.id.rdoRepeat);
        rdoRepeatGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdoRepeatPicked = (RadioButton) rdoRepeatGroup.findViewById(checkedId);
                repeatSelected = rdoRepeatPicked.getText().toString();
            }
        });

        rdoNoticeGroup = (RadioGroup) v.findViewById(R.id.rdoNotice);
        rdoNoticeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdoNoticePicked = (RadioButton) rdoNoticeGroup.findViewById(checkedId);
                noticeSelected = rdoNoticePicked.getText().toString();
            }
        });

        btnSave = (Button) v.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repeatSelected==null || noticeSelected==null){
                    Toast.makeText(getActivity(),"반복 여부와 몇 분 전에 알릴 지를 선택해 주세요",Toast.LENGTH_SHORT).show();
                }else {
                    Bundle data = new Bundle();
                    data.putInt("year", year);
                    data.putInt("month", month);
                    data.putInt("day", day);
                    data.putString("name", txtName.getText().toString());
                    data.putInt("hour", tPicker.getCurrentHour());
                    data.putInt("minute", tPicker.getCurrentMinute());
                    data.putString("repeat", repeatSelected);
                    data.putString("notice", noticeSelected);

                    listener.onScheduleSent(data);
                }
            }
        });
        return v;
    }
}
