package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChatContentsResult {
    @Expose
    @SerializedName("senderIdx")
    private int senderIdx;
    @Expose
    @SerializedName("receiverIdx")
    private int receiverIdx;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("time")
    private String time;

    public ChatContentsResult(){};
    public ChatContentsResult(int senderIdx, int receiverIdx, String message, String time) {
        this.senderIdx = senderIdx;
        this.receiverIdx = receiverIdx;
        this.message = message;
        this.time = time;
    }

    public int getSenderIdx() {
        return senderIdx;
    }

    public void setSenderIdx(int senderIdx) {
        this.senderIdx = senderIdx;
    }

    public int getReceiverIdx() {
        return receiverIdx;
    }

    public void setReceiverIdx(int receiverIdx) {
        this.receiverIdx = receiverIdx;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
