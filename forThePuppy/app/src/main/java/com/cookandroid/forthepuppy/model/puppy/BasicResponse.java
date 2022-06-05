package com.cookandroid.forthepuppy.model.puppy;

import com.google.gson.annotations.SerializedName;

public class BasicResponse {
    @SerializedName("isSuccess") private boolean isSuccess;
    @SerializedName("code") private int code;
    @SerializedName("message") private String message;
    @SerializedName("result") private int result;

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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BasicResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
