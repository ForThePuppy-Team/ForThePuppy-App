package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsResult {
    @Expose
    @SerializedName("categoryName")
    private String categoryName;
    @Expose
    @SerializedName("postIdx")
    private int postIdx;
    @Expose
    @SerializedName("userIdx")
    private int userIdx;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("profile")
    private String profile;
    @Expose
    @SerializedName("region")
    private String region;
    @Expose
    @SerializedName("uploadTime")
    private String uploadTime;
    @Expose
    @SerializedName("content")
    private String content;
    @Expose
    @SerializedName("images")
    private List<String> images = null;
    @Expose
    @SerializedName("getPostComments")
    private List<getPostComments> postsResults = null;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(int postIdx) {
        this.postIdx = postIdx;
    }

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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<getPostComments> getPostsResults() {
        return postsResults;
    }

    public void setPostsResults(List<getPostComments> postsResults) {
        this.postsResults = postsResults;
    }
}
