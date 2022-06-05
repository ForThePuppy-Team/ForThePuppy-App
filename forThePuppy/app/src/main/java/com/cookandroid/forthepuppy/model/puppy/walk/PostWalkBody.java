package com.cookandroid.forthepuppy.model.puppy.walk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.sql.Time;

public class PostWalkBody {
    @Expose
    @SerializedName("date") String date;
    @Expose
    @SerializedName("startTime") String startTime;
    @Expose
    @SerializedName("endTime") String endTime;
    @Expose
    @SerializedName("totalDistance") double totalDistance;
    @Expose
    @SerializedName("totalTime") long totalTime;
    @Expose
    @SerializedName("userIdx") int userIdx;
    @Expose
    @SerializedName("puppyIdx") int puppyIdx;

    public PostWalkBody(){

    }

    public PostWalkBody(String date, String startTime, String endTime, double totalDistance, long totalTime, int userIdx, int puppyIdx) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.userIdx = userIdx;
        this.puppyIdx = puppyIdx;
    }
}
