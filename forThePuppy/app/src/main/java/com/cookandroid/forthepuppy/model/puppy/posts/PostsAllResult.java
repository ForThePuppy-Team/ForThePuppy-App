package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsAllResult {
    @Expose
    @SerializedName("userIdx")
    private int userIdx;
    @Expose
    @SerializedName("postIdx")
    private int postIdx;
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
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("content")
    private String content;
    @Expose
    @SerializedName("commentCount")
    private int commentCount;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("categoryName")
    private String categoryName;

    public PostsAllResult() {
    }

    public PostsAllResult(int userIdx, int postIdx, String profile, String name, String region, String uploadTime, String title, String content, int commentCount, String date, String categoryName) {
        this.userIdx = userIdx;
        this.postIdx = postIdx;
        this.profile = profile;
        this.name = name;
        this.region = region;
        this.uploadTime = uploadTime;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
        this.date = date;
        this.categoryName = categoryName;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public int getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(int postIdx) {
        this.postIdx = postIdx;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "PostsResult{" +
                "userIdx=" + userIdx +
                ", postIdx=" + postIdx +
                ", profile='" + profile + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                ", date='" + date + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
