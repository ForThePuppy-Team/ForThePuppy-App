package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChattingResponse {
    @Expose
    @SerializedName("isSuccess") private boolean isSuccess;
    @Expose
    @SerializedName("code") private int code;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("result")  private List<ChattingResult> chattingResult = null;

    public List<ChattingResult> getChattingResult() {
        return chattingResult;
    }

    public void setChattingResult(List<ChattingResult> chattingResult) {
        this.chattingResult = chattingResult;
    }

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


}
