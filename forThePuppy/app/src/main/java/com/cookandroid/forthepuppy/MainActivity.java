package com.cookandroid.forthepuppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.cookandroid.forthepuppy.ui.chatting.ChattingFragment;
import com.cookandroid.forthepuppy.ui.home.HomeFragment;
import com.cookandroid.forthepuppy.ui.my_page.MyPageFragment;
import com.cookandroid.forthepuppy.ui.surrounding_facilities.SurroundingFacilitiesFragment;
import com.cookandroid.forthepuppy.ui.walk.WalkFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    WalkFragment walkFragment;
    ChattingFragment chattingFragment;
    SurroundingFacilitiesFragment surroundingFacilitiesFragment;
    MyPageFragment myPageFragment;

    @Override
    public void onBackPressed() {
        if (!(getSupportFragmentManager().getFragments().get(0) instanceof HomeFragment)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                    homeFragment).commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        walkFragment = new WalkFragment();
        chattingFragment = new ChattingFragment();
        surroundingFacilitiesFragment = new SurroundingFacilitiesFragment();
        myPageFragment = new MyPageFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.containers, homeFragment).commit();

        // 하단바
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavigationView);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                                homeFragment).commit();
                        return true;
                    case R.id.navigation_walk:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                                walkFragment).commit();
                        return true;
                    case R.id.navigation_chatting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                                chattingFragment).commit();
                        return true;
                    case R.id.navigation_surrounding_facilities:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                                surroundingFacilitiesFragment).commit();
                        return true;
                    case R.id.navigation_my_page:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                                myPageFragment).commit();
                        return true;

                }
                return false;
            }
        });


    }
}