package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.cookandroid.forthepuppy.model.puppy.walk.WalkResult;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatResponse {
    @Expose
    @SerializedName("isSuccess") private boolean isSuccess;
    @Expose
    @SerializedName("code") private int code;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("result")  private List<ChatResult> chatResults = null;

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

    public List<ChatResult> getChatResults() {
        return chatResults;
    }

    public void setChatResults(List<ChatResult> chatResults) {
        this.chatResults = chatResults;
    }
}
