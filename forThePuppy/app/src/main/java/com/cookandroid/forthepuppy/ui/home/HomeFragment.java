package com.cookandroid.forthepuppy.ui.home;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cookandroid.forthepuppy.MainActivity;
import com.cookandroid.forthepuppy.R;
import com.cookandroid.forthepuppy.api.ApiClientPuppy;
import com.cookandroid.forthepuppy.api.ApiInterfacePuppy;
import com.cookandroid.forthepuppy.model.puppy.BasicResponse;
import com.cookandroid.forthepuppy.model.puppy.calendars.CalendarsResponse;
import com.cookandroid.forthepuppy.model.puppy.calendars.PostCalendars;
import com.cookandroid.forthepuppy.model.puppy.posts.PostPostsBody;
import com.cookandroid.forthepuppy.model.puppy.posts.PostsAllResponse;
import com.cookandroid.forthepuppy.model.puppy.posts.PostsChangeBody;
import com.cookandroid.forthepuppy.model.puppy.posts.PostsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    Button postFamilies, postFamiliesAccount,patchFamilies, patchFamiliesAccount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.homeToolbar);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        // 가족등록
        postFamilies = (Button) view.findViewById(R.id.postFamilies);
        postFamilies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.postFamilies("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTQwODIzODYsImV4cCI6MTY1NTU1MzYxNX0.L1y5KPr2YOWyUqzuB-YaKZFMGcgs3yRYCCXKzyIuOEc", 2, 1);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postFamilies = response.body();
                        Log.d("postFamilies", postFamilies.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });

        // 가족계정 생성
        postFamiliesAccount = (Button) view.findViewById(R.id.postFamiliesAccount);
        postFamiliesAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.postFamiliesAccount("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 1);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postFamilies = response.body();
                        Log.d("postFamiliesAccount", postFamilies.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });

        // 가족계정 삭제
        patchFamiliesAccount = (Button) view.findViewById(R.id.patchFamiliesAccount);
        patchFamiliesAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.patchFamiliesAccount("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 1,1);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postFamilies = response.body();
                        Log.d("patchFamiliesAccount", postFamilies.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });
        // 가족 삭제
        patchFamilies = (Button) view.findViewById(R.id.patchFamilies);
        patchFamilies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call = apiInterfacePuppy.patchFamilies("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 1, 1);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postFamilies = response.body();
                        Log.d("patchFamilies", postFamilies.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });
            }
        });

        Button testApi = (Button) view.findViewById(R.id.testApi);
        testApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //일정등록
/*                PostCalendars postCalendars = new PostCalendars("밥시간","밥시간","2022-02-02","2022-02-02",
                       "22:22:00","22:22:00",1,2,"0",1 );
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call8 = apiInterfacePuppy.postCalendars("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk",
                        postCalendars);
                call8.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postPosts = response.body();
                        Log.d("postCalendars", postPosts.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });*/

                // 특정날짜 조회
/*                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<CalendarsResponse> call8 = apiInterfacePuppy.getCalendars("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk",3,1);
                call8.enqueue(new Callback<CalendarsResponse>() {
                    @Override
                    public void onResponse(Call<CalendarsResponse> call, Response<CalendarsResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        CalendarsResponse getCalendar = response.body();
                        Log.d("postCalendars", getCalendar.getMessage());
                    }

                    @Override
                    public void onFailure(Call<CalendarsResponse> call, Throwable t) {
                        Log.d("postCalendars실패",  "onFailure");
                    }
                });*/

                // 일정삭제
                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call8 = apiInterfacePuppy.patchCalendars("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM3MjE1NjIsImV4cCI6MTY1NTE5Mjc5MX0.pOEH_9Ejdv63Yn7_agRmzHqBOUgnzX2rTG4TbI7RWz4",1,1);
                call8.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse patchCalendars = response.body();
                        Log.d("patchCalendars", patchCalendars.getMessage());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {
                        Log.d("patchCalendars실패",  "onFailure");
                    }
                });

      /*          // 게시글 등록
                PostPostsBody postPostsBody = new PostPostsBody("대리산책자 구해요", "자세한내용은 메세지로 얘기해요", 1, 1);

                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call8 = apiInterfacePuppy.postPosts("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk",
                        postPostsBody);
                call8.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        BasicResponse postPosts = response.body();
                        Log.d("postPosts", postPosts.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {

                    }
                });

                // 전체 게시글 조회
//                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<PostsAllResponse> call4 = apiInterfacePuppy.getPostsAll("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 1,"역북동");
                call4.enqueue(new Callback<PostsAllResponse>() {

                    @Override
                    public void onResponse(Call<PostsAllResponse> call, Response<PostsAllResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        PostsAllResponse postsAllResponse = response.body();
//                        PostsResult postsResult = postsResponse.getPostsResults().get(0); //내용물이 없어서.. 게시글 넣은 뒤에 가능
                        Log.d("getPosts", postsAllResponse.getMessage() + "\n");
                    }

                    @Override
                    public void onFailure(Call<PostsAllResponse> call, Throwable t) {

                    }
                });

                // 게시글 조회
//                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<PostsResponse> call = apiInterfacePuppy.getPosts("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 1,1);
                call.enqueue(new Callback<PostsResponse>() {

                    @Override
                    public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패",  response.toString());
                            return;
                        }

                        PostsResponse postsResponse = response.body();
//                        PostsResult postsResult = postsResponse.getPostsResults().get(0); //내용물이 없어서.. 게시글 넣은 뒤에 가능
                        Log.d("getPosts", postsResponse.getMessage() + "\n");
                    }

                    @Override
                    public void onFailure(Call<PostsResponse> call, Throwable t) {

                    }
                });

                // 게시글 삭제 // 왜인지 서버꺼있을때 오는 onFailure로 응답이 와서 안됨
//                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call2 = apiInterfacePuppy.patchPosts("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM3MjE1NjIsImV4cCI6MTY1NTE5Mjc5MX0.pOEH_9Ejdv63Yn7_agRmzHqBOUgnzX2rTG4TbI7RWz4", 1,1);
                call2.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("patchPosts실패",  response.toString());
                            return;
                        }

                        BasicResponse b = response.body();
//                        PostsResult postsResult = postsResponse.getPostsResults().get(0); //내용물이 없어서.. 게시글 넣은 뒤에 가능
                        Log.d("patchPosts", b.getMessage() + "\n");
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {
                        Log.d("patchPosts실패",  "onFailure");
                    }
                });

                // 게시글 수정
               PostsChangeBody postsChangeBody = new PostsChangeBody("hi","hiu");
//                ApiInterfacePuppy apiInterfacePuppy = ApiClientPuppy.getApiClient().create(ApiInterfacePuppy.class);
                Call<BasicResponse> call3 = apiInterfacePuppy.postPostsChange("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk",1,1, postsChangeBody);
                call3.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("postPostsChange실패",  response.toString());
                            return;
                        }

                        BasicResponse postPosts = response.body();
                        Log.d("postPostsChange", postPosts.toString());
                    }

                    @Override
                    public void onFailure(Call<BasicResponse> call, Throwable t) {
                        Log.d("postPostsChange실패",  "onFailure");
                    }
                });*/



            }
       });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.home_toolbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (item.getItemId() == R.id.homeMenu) {
            Log.i("ss","메뉴");
            return true;
        }

        switch (item.getItemId()){
            case R.id.homeMenu:
                Log.i("ss","메뉴");
                break;
            case R.id.homeSettings:
                Log.i("ss","환경설정");
                break;
            case R.id.homeAlram:

                Log.i("ss","알람");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}