package com.cookandroid.forthepuppy.api;

import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.walk.PostWalkBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
