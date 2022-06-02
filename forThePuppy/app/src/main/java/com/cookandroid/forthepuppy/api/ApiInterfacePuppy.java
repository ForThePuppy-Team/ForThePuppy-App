package com.cookandroid.forthepuppy.api;

import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChatResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.ChattingResponse;
import com.cookandroid.forthepuppy.model.puppy.chatting.PostChatBody;
import com.cookandroid.forthepuppy.model.puppy.chatting.PostChattingBody;
import com.cookandroid.forthepuppy.model.puppy.walk.PostWalkBody;
import com.cookandroid.forthepuppy.model.puppy.walk.WalkResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterfacePuppy {

    //산책 정보 가져오기
/*    @GET("???")
    Call<CategoryResult> getSearchCategory(
            @Header("Authorization") String token,
            @Query("radius") int radius
    );*/

    //산책정보 등록
    @POST("/walks")
    Call<BasicResponse> postWalkData(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Body PostWalkBody postWalkBody
    );

    //산책정보 조회
    @GET("/walks/{userIdx}")
    Call<WalkResponse> getWalkData(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("userIdx") int userIdx
    );

    //채팅방 생성성
    @POST("/chats")
    Call<BasicResponse> postChats(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Body PostChatBody postChatBody
    );

    //채팅목록조회
    @GET("/chats/{userIdx}")
    Call<ChatResponse> getChatList(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("userIdx") int userIdx
    );

    //채팅내역조회
    @GET("/chats/{userIdx}/{roomIdx}")
    Call<ChattingResponse> getChattingList(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("userIdx") int userIdx,
            @Path("roomIdx") int roomIdx
    );

    //채팅 메시지 생성
    @POST("/chats/{roomIdx}/message")
    Call<BasicResponse> postChatting(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Body PostChattingBody postChattingBody,
            @Path("roomIdx") int roomIdx
    );

   // 가족등록
    @POST("/families/{idx}/{userIdx}")
    Call<BasicResponse> postFamilies(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("idx") int idx,
            @Path("userIdx") int userIdx
    );

    // 가족계정 생성
    @POST("/families/{userIdx}")
    Call<BasicResponse> postFamiliesAccount(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("userIdx") int userIdx
    );

    // 가족계정 삭제
    @PATCH("/families/{idx}/{userIdx}/account-status")
    Call<BasicResponse> patchFamiliesAccount(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("idx") int idx,
            @Path("userIdx") int userIdx
    );

    @PATCH("/families/{idx}/{userIdx}/member-status")
    Call<BasicResponse> patchFamilies(
            @Header("X-ACCESS-TOKEN") String X_ACCESS_TOKEN,
            @Path("idx") int idx,
            @Path("userIdx") int userIdx
    );
}
