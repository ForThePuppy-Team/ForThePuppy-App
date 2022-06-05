package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getPostComments {
    @Expose
    @SerializedName("userIdx")
    private int userIdx;
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
    @SerializedName("comment")
    private String comment;

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
