package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatResult {
    @Expose
    @SerializedName("roomIdx")
    private int roomIdx;
    @Expose
    @SerializedName("userIdx")
    private int userIdx;
    @Expose
    @SerializedName("profile")
    private String profile;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("region")
    private String region;
    @Expose
    @SerializedName("uploadTime")
    private String uploadTime;
    @Expose
    @SerializedName("lastMessage")
    private String lastMessage;

    public ChatResult(){};

    public ChatResult(int roomIdx, int userIdx, String profile, String name, String region, String uploadTime, String lastMessage) {
        this.roomIdx = roomIdx;
        this.userIdx = userIdx;
        this.profile = profile;
        this.name = name;
        this.region = region;
        this.uploadTime = uploadTime;
        this.lastMessage = lastMessage;
    }

    public int getRoomIdx() {
        return roomIdx;
    }

    public void setRoomIdx(int roomIdx) {
        this.roomIdx = roomIdx;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
