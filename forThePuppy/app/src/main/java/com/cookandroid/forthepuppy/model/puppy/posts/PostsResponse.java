package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsResponse {
    @Expose
    @SerializedName("isSuccess") private boolean isSuccess;
    @Expose
    @SerializedName("code") private int code;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("result")  private List<PostsResult> postsResults = null;

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

    public List<PostsResult> getPostsResults() {
        return postsResults;
    }

    public void setPostsResults(List<PostsResult> postsResults) {
        this.postsResults = postsResults;
    }
}
