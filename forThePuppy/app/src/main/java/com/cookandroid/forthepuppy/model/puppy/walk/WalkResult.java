package com.cookandroid.forthepuppy.model.puppy.walk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.sql.Time;

public class WalkResult {
    @Expose
    @SerializedName("puppyIdx")
    private int puppyIdx;
    @Expose
    @SerializedName("puppyName")
    private String puppyName;
    @Expose
    @SerializedName("puppyGender")
    private String puppyGender;
    @Expose
    @SerializedName("puppyPhoto")
    private String puppyPhoto;
    @Expose
    @SerializedName("breed")
    private String breed;
    @Expose
    @SerializedName("walkIdx")
    private int walkIdx;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("startTime")
    private String startTime;
    @Expose
    @SerializedName("endTime")
    private String endTime;
    @Expose
    @SerializedName("totalDistance")
    private Double totalDistance;
    @Expose
    @SerializedName("totalTime")
    private long totalTime;

    public WalkResult(){}

    public WalkResult(int puppyIdx, String puppyName, String puppyGender, String puppyPhoto, String breed, int walkIdx, String date, String startTime, String endTime, Double totalDistance, long totalTime) {
        this.puppyIdx = puppyIdx;
        this.puppyName = puppyName;
        this.puppyGender = puppyGender;
        this.puppyPhoto = puppyPhoto;
        this.breed = breed;
        this.walkIdx = walkIdx;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public int getPuppyIdx() {
        return puppyIdx;
    }

    public void setPuppyIdx(int puppyIdx) {
        this.puppyIdx = puppyIdx;
    }

    public String getPuppyName() {
        return puppyName;
    }

    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public String getPuppyGender() {
        return puppyGender;
    }

    public void setPuppyGender(String puppyGender) {
        this.puppyGender = puppyGender;
    }

    public String getPuppyPhoto() {
        return puppyPhoto;
    }

    public void setPuppyPhoto(String puppyPhoto) {
        this.puppyPhoto = puppyPhoto;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWalkIdx() {
        return walkIdx;
    }

    public void setWalkIdx(int walkIdx) {
        this.walkIdx = walkIdx;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "WalkResult{" +
                "puppyIdx=" + puppyIdx +
                ", puppyName='" + puppyName + '\'' +
                ", puppyGender='" + puppyGender + '\'' +
                ", puppyPhoto='" + puppyPhoto + '\'' +
                ", breed='" + breed + '\'' +
                ", walkIdx=" + walkIdx +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", totalDistance=" + totalDistance +
                ", totalTime=" + totalTime +
                '}';
    }
}
