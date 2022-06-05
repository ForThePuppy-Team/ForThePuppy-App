package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPostsBody {
    @Expose
    @SerializedName("title") String title;
    @Expose
    @SerializedName("content") String content;
    @Expose
    @SerializedName("category") int category;
    @Expose
    @SerializedName("userIdx") int userIdx;

    public PostPostsBody(String title, String content, int category, int userIdx) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.userIdx = userIdx;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    @Override
    public String toString() {
        return "PostsBody{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", categoryIdx=" + category +
                ", userIdx=" + userIdx +
                '}';
    }
}
