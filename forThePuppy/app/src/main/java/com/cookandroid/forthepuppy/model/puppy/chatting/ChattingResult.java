package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChattingResult {
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
    @SerializedName("startDate")
    private String startDate;
    @Expose
    @SerializedName("chatContents")
    private List<ChatContentsResult> chatContents = null;

    public ChattingResult(){};

    public ChattingResult(int roomIdx, int userIdx, String profile, String name, String startDate, List<ChatContentsResult> chatContents) {
        this.roomIdx = roomIdx;
        this.userIdx = userIdx;
        this.profile = profile;
        this.name = name;
        this.startDate = startDate;
        this.chatContents = chatContents;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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

    public List<ChatContentsResult> getChatContents() {
        return chatContents;
    }

    public void setChatContents(List<ChatContentsResult> chatContents) {
        this.chatContents = chatContents;
    }
}
