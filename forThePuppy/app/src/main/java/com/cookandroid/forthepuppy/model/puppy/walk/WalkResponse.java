package com.cookandroid.forthepuppy.model.puppy.walk;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import com.cookandroid.forthepuppy.model.kakao.category_search.Document;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WalkResponse{
    @Expose
    @SerializedName("isSuccess") private boolean isSuccess;
    @Expose
    @SerializedName("code") private int code;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("result")  private List<WalkResult> walkResults = null;

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

    public List<WalkResult> getWalkResults() {
        return walkResults;
    }

    public void setWalkResults(List<WalkResult> walkResults) {
        this.walkResults = walkResults;
    }
}
