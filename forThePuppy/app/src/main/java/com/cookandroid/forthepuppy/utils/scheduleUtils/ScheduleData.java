package com.cookandroid.forthepuppy.utils.scheduleUtils;

public class ScheduleData {
    private int hour;
    private int minute;
    private String name;

    public ScheduleData(int hour, int minute, String name){
        this.hour = hour;
        this.minute = minute;
        this.name = name;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public String getName() {
        return this.name;
    }
}
