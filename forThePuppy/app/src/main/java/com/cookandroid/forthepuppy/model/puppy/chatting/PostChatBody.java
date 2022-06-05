package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostChatBody {
    @Expose
    @SerializedName("senderIdx") int senderIdx;
    @Expose
    @SerializedName("receiverIdx") int receiverIdx;
    @Expose
    @SerializedName("content") String content;

    public PostChatBody(){};

    public PostChatBody(int senderIdx, int receiverIdx, String content) {
        this.senderIdx = senderIdx;
        this.receiverIdx = receiverIdx;
        this.content = content;
    }
}
