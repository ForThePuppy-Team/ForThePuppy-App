package com.cookandroid.forthepuppy.model.puppy.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsChangeBody {
    @Expose
    @SerializedName("title") String title;
    @Expose
    @SerializedName("content") String content;

    public PostsChangeBody(String title, String content) {
        this.title = title;
        this.content = content;
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
}
