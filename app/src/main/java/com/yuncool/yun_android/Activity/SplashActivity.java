package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.yuncool.yun_android.R;


public class SplashActivity extends BaseActivity {


    private final int SPLASH_DISPLAY_LENGHT = 2000; //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
                String userInfo = pref.getString("userInfo", "");

                Intent intent;

                if (userInfo.equals("")) {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);

                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);

                }

                startActivity(intent);
                finish();
            }

        }, SPLASH_DISPLAY_LENGHT);
    }
}



