package com.yuncool.yun_android.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.Fragment.FavorableShopsFragment;
import com.yuncool.yun_android.Fragment.MainFragment;
import com.yuncool.yun_android.Fragment.ScanFragment;
import com.yuncool.yun_android.Fragment.UserCenterFragment;

public class MainActivity extends BaseActivity {

    private RadioGroup rg_main;
    private RadioButton rb_main, rb_scan, rb_shop_cart, rb_user_center;
    private FrameLayout fl_fragment;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private final static int MAIN = 0, SCAN = 1, FAVORABLE_SHOP = 2, USER_CENTER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView() {
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        rb_main = (RadioButton) findViewById(R.id.rb_main);
        rb_scan = (RadioButton) findViewById(R.id.rb_scan);
        rb_shop_cart = (RadioButton) findViewById(R.id.rb_shop_cart);
        rb_user_center = (RadioButton) findViewById(R.id.rb_user_center);
        fl_fragment = (FrameLayout) findViewById(R.id.fl_fragment);

    }

    private void initEvent() {

        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();

                switch (i) {
                    case R.id.rb_main:

                        MainFragment mainFragment = new MainFragment();
                        fragmentTransaction.replace(R.id.fl_fragment, mainFragment);
                        fragmentTransaction.commit();

                        break;
                    case R.id.rb_scan:

                        ScanFragment scanFragment = new ScanFragment();
                        fragmentTransaction.replace(R.id.fl_fragment, scanFragment);
                        fragmentTransaction.commit();

                        break;
                    case R.id.rb_shop_cart:

                        FavorableShopsFragment favorableShopsFragment = new FavorableShopsFragment();
                        fragmentTransaction.replace(R.id.fl_fragment, favorableShopsFragment);
                        fragmentTransaction.commit();

                        break;
                    case R.id.rb_user_center:

                        UserCenterFragment userCenterFragment = new UserCenterFragment();
                        fragmentTransaction.replace(R.id.fl_fragment, userCenterFragment);
                        fragmentTransaction.commit();

                        break;
                    default:
                        break;
                }


            }
        });

    }
}
