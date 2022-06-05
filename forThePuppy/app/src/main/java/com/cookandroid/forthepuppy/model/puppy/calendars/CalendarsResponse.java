package com.cookandroid.forthepuppy.model.puppy.calendars;

import com.cookandroid.forthepuppy.model.puppy.walk.WalkResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CalendarsResponse {
    @Expose
    @SerializedName("isSuccess") private boolean isSuccess;
    @Expose
    @SerializedName("code") private int code;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("result")  private List<CalendarsResult> CalendarsResult = null;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<com.cookandroid.forthepuppy.model.puppy.calendars.CalendarsResult> getCalendarsResult() {
        return CalendarsResult;
    }

    public void setCalendarsResult(List<com.cookandroid.forthepuppy.model.puppy.calendars.CalendarsResult> calendarsResult) {
        CalendarsResult = calendarsResult;
    }
}
