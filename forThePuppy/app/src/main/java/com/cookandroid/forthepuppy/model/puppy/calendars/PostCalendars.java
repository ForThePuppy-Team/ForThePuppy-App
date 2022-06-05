package com.cookandroid.forthepuppy.model.puppy.calendars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostCalendars {
    @Expose
    @SerializedName("scheduleContent") String scheduleContent;
    @Expose
    @SerializedName("detail") String detail;
    @Expose
    @SerializedName("startDate") String startDate;
    @Expose
    @SerializedName("endDate") String endDate;
    @Expose
    @SerializedName("startTime") String startTime;
    @Expose
    @SerializedName("endTime") String endTime;
    @Expose
    @SerializedName("alert") int alert;
    @Expose
    @SerializedName("scheduleCategoryIdx") int scheduleCategoryIdx;
    @Expose
    @SerializedName("scheduleColor") String scheduleColor;
    @Expose
    @SerializedName("userIdx") int userIdx;

    public PostCalendars(String scheduleContent, String detail, String startDate, String endDate, String startTime, String endTime, int alert, int scheduleCategoryIdx, String scheduleColor, int userIdx) {
        this.scheduleContent = scheduleContent;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.alert = alert;
        this.scheduleCategoryIdx = scheduleCategoryIdx;
        this.scheduleColor = scheduleColor;
        this.userIdx = userIdx;
    }

    public String getScheduleContent() {
        return scheduleContent;
    }

    public void setScheduleContent(String scheduleContent) {
        this.scheduleContent = scheduleContent;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public int getScheduleCategoryIdx() {
        return scheduleCategoryIdx;
    }

    public void setScheduleCategoryIdx(int scheduleCategoryIdx) {
        this.scheduleCategoryIdx = scheduleCategoryIdx;
    }

    public String getScheduleColor() {
        return scheduleColor;
    }

    public void setScheduleColor(String scheduleColor) {
        this.scheduleColor = scheduleColor;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }
}
