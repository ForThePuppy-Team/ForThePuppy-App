package com.cookandroid.forthepuppy.model.puppy.chatting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostChattingBody {
    @Expose
    @SerializedName("message") String message;
    @Expose
    @SerializedName("image") String image;
    @Expose
    @SerializedName("receiverIdx") int receiverIdx;
    @Expose
    @SerializedName("senderIdx") int senderIdx;

    public PostChattingBody() {};

    public PostChattingBody(String message, String image, int receiverIdx, int senderIdx) {
        this.message = message;
        this.image = image;
        this.receiverIdx = receiverIdx;
        this.senderIdx = senderIdx;
    }
}
