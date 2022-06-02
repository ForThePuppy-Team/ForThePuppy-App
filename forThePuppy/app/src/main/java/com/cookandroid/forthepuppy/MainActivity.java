package com.cookandroid.forthepuppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.cookandroid.forthepuppy.model.puppy.chatting.ChatResult;
import com.cookandroid.forthepuppy.ui.chatting.ChatCreateFragment;
import com.cookandroid.forthepuppy.ui.chatting.ChattingFragment;
import com.cookandroid.forthepuppy.ui.chatting.ChatListFragment;
import com.cookandroid.forthepuppy.ui.chatting.ChattingListFragment;
import com.cookandroid.forthepuppy.ui.home.HomeFragment;
import com.cookandroid.forthepuppy.ui.my_page.MyPageFragment;
import com.cookandroid.forthepuppy.ui.surrounding_facilities.SurroundingFacilitiesFragment;
import com.cookandroid.forthepuppy.ui.walk.WalkFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    int userIdx = 1;
    int puppyIdx = 1;
    String X_ACCESS_TOKEN = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1c2VySWR4IjoxLCJpYXQiOjE2NTM3MjE1NjIsImV4cCI6MTY1NTE5Mjc5MX0.pOEH_9Ejdv63Yn7_agRmzHqBOUgnzX2rTG4TbI7RWz4";

    HomeFragment homeFragment;
    WalkFragment walkFragment;
    ChattingFragment chattingFragment;
    SurroundingFacilitiesFragment surroundingFacilitiesFragment;
    MyPageFragment myPageFragment;

    // 서브 프레그먼트
    ChatCreateFragment chatCreateFragment;
    ChatListFragment chatListFragment;
    ChattingListFragment chattingListFragment;

    FragmentManager fragmentManager;
    LocationManager lm;

    private double longitude = 0.0;
    private double latitude = 0.0;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static int t = 0;

    public WalkFragment getWalkFragment() {
        return walkFragment;
    }

    @Override
    public void onBackPressed() {
        if (!(getSupportFragmentManager().getFragments().get(0) instanceof HomeFragment)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.containers,
                    homeFragment).commit();
        } else {
            super.onBackPressed();
        }
    }

    public void temp() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        // LocationManager 객체를 얻어온다
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        try {
            // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                    100, // 통지사이의 최소 시간간격 (miliSecond)
                    1, // 통지사이의 최소 변경거리 (m)
                    mLocationListener);
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                    100, // 통지사이의 최소 시간간격 (miliSecond)
                    1, // 통지사이의 최소 변경거리 (m)
                    mLocationListener);

        } catch (SecurityException ex) {
        }


        // 화면들
        homeFragment = new HomeFragment();
//        walkFragment = new WalkFragment();
//        chattingFragment = new ChattingFragment();
//        surroundingFacilitiesFragment = new SurroundingFacilitiesFragment();
//        myPageFragment = new MyPageFragment();

        fragmentManager.beginTransaction().replace(R.id.containers, homeFragment).commit();

        // 하단바
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 서브 화면들 있으면 제거
                if (chatCreateFragment != null) {
                    fragmentManager.beginTransaction().remove(chatCreateFragment).commit();
                    chatCreateFragment = null;
                }
                if (chatListFragment != null) {
                    fragmentManager.beginTransaction().remove(chatListFragment).commit();
                    chatListFragment = null;
                }
                if (chattingListFragment != null) {
                    fragmentManager.beginTransaction().remove(chattingListFragment).commit();
                    chattingListFragment = null;
                }


                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        if (homeFragment == null) {
                            homeFragment = new HomeFragment();
                            fragmentManager.beginTransaction().add(R.id.containers, homeFragment).commit();
                        }
                        if (homeFragment != null)
                            fragmentManager.beginTransaction().show(homeFragment).commit();
                        if (walkFragment != null)
                            fragmentManager.beginTransaction().hide(walkFragment).commit();
                        if (chattingFragment != null)
                            fragmentManager.beginTransaction().hide(chattingFragment).commit();
                        if (surroundingFacilitiesFragment != null)
                            fragmentManager.beginTransaction().hide(surroundingFacilitiesFragment).commit();
                        if (myPageFragment != null)
                            fragmentManager.beginTransaction().hide(myPageFragment).commit();

                        return true;
                    case R.id.navigation_walk:
                        if (walkFragment == null) {
                            walkFragment = new WalkFragment(userIdx,puppyIdx,X_ACCESS_TOKEN);
                            fragmentManager.beginTransaction().add(R.id.containers, walkFragment).commit();
                        }
                        if (homeFragment != null)
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                        if (walkFragment != null)
                            fragmentManager.beginTransaction().show(walkFragment).commit();
                        if (chattingFragment != null)
                            fragmentManager.beginTransaction().hide(chattingFragment).commit();
                        if (surroundingFacilitiesFragment != null)
                            fragmentManager.beginTransaction().hide(surroundingFacilitiesFragment).commit();
                        if (myPageFragment != null)
                            fragmentManager.beginTransaction().hide(myPageFragment).commit();


                        return true;
                    case R.id.navigation_chatting:
                        if (chattingFragment == null) {
                            chattingFragment = new ChattingFragment();
                            fragmentManager.beginTransaction().add(R.id.containers, chattingFragment).commit();
                        }
                        if (homeFragment != null)
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                        if (walkFragment != null)
                            fragmentManager.beginTransaction().hide(walkFragment).commit();
                        if (chattingFragment != null)
                            fragmentManager.beginTransaction().show(chattingFragment).commit();
                        if (surroundingFacilitiesFragment != null)
                            fragmentManager.beginTransaction().hide(surroundingFacilitiesFragment).commit();
                        if (myPageFragment != null)
                            fragmentManager.beginTransaction().hide(myPageFragment).commit();
                        return true;
                    case R.id.navigation_surrounding_facilities:
                        if (surroundingFacilitiesFragment == null) {
                            surroundingFacilitiesFragment = new SurroundingFacilitiesFragment();
                            fragmentManager.beginTransaction().add(R.id.containers, surroundingFacilitiesFragment).commit();
                        }
                        if (homeFragment != null)
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                        if (walkFragment != null)
                            fragmentManager.beginTransaction().hide(walkFragment).commit();
                        if (chattingFragment != null)
                            fragmentManager.beginTransaction().hide(chattingFragment).commit();
                        if (surroundingFacilitiesFragment != null)
                            fragmentManager.beginTransaction().show(surroundingFacilitiesFragment).commit();
                        if (myPageFragment != null)
                            fragmentManager.beginTransaction().hide(myPageFragment).commit();
                        return true;
                    case R.id.navigation_my_page:
                        if (myPageFragment == null) {
                            myPageFragment = new MyPageFragment();
                            fragmentManager.beginTransaction().add(R.id.containers, myPageFragment).commit();
                        }
                        if (homeFragment != null)
                            fragmentManager.beginTransaction().hide(homeFragment).commit();
                        if (walkFragment != null)
                            fragmentManager.beginTransaction().hide(walkFragment).commit();
                        if (chattingFragment != null)
                            fragmentManager.beginTransaction().hide(chattingFragment).commit();
                        if (surroundingFacilitiesFragment != null)
                            fragmentManager.beginTransaction().hide(surroundingFacilitiesFragment).commit();
                        if (myPageFragment != null)
                            fragmentManager.beginTransaction().show(myPageFragment).commit();
                        return true;

                }
                return false;
            }
        });

    }
    private final LocationListener mLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.

            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도

            // 한번 업데이트되면 멈춘다
            if (longitude != 0 && latitude != 0) {
                lm.removeUpdates(mLocationListener);
            }

        }

        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d("test", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d("test", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d("test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }
    };

    public void newChat(int senderIdx, int receiverIdx) {
        if (chattingFragment != null)
            fragmentManager.beginTransaction().hide(chattingFragment).commit();
        chatCreateFragment = new ChatCreateFragment(X_ACCESS_TOKEN,
                senderIdx,receiverIdx);
        fragmentManager.beginTransaction().add(R.id.containers, chatCreateFragment).show(chatCreateFragment).commit();
    }

    public void viewChangeChatting(){
        if (chatCreateFragment != null) {
            fragmentManager.beginTransaction().remove(chatCreateFragment).commit();
            chatCreateFragment = null;
        }
        if (chattingFragment != null)
            fragmentManager.beginTransaction().show(chattingFragment).commit();
    }

    public void chattingInventory() {
        if (chattingFragment != null)
            fragmentManager.beginTransaction().hide(chattingFragment).commit();
        chatListFragment = new ChatListFragment(1, X_ACCESS_TOKEN);
        fragmentManager.beginTransaction().add(R.id.containers, chatListFragment).show(chatListFragment).commit();

    }

    public void chattingRoom(ChatResult chatResult, int userIdx) {
        if (chatListFragment != null)
            fragmentManager.beginTransaction().hide(chatListFragment).commit();
        chattingListFragment = new ChattingListFragment(chatResult, X_ACCESS_TOKEN, userIdx);
        fragmentManager.beginTransaction().add(R.id.containers, chattingListFragment).show(chattingListFragment).commit();
    }

}