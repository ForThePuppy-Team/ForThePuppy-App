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
                Call<BasicResponse> call = apiInterfacePuppy.postFamilies("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM2MjQ0MzAsImV4cCI6MTY1NTA5NTY1OX0.ZiDhOe9bf6dOXCZyWVFPro7FOJ91iIl7XRdFtOz-6Lk", 2, 1);
                call.enqueue(new Callback<BasicResponse>() {
                    @Override
                    public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
                        if (!response.isSuccessful()) {
                            Log.d("실패", "실패");
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
                            Log.d("실패", "실패");
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
                            Log.d("실패", "실패");
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
                            Log.d("실패", "실패");
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