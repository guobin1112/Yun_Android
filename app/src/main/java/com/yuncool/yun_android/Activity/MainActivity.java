package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuncool.yun_android.R;

public class MainActivity extends BaseActivity {

    RadioGroup rg_main;
    RadioButton rb_main,rb_scan,rb_shop_cart,rb_user_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        rg_main= (RadioGroup) findViewById(R.id.rg_main);
        rb_main= (RadioButton) findViewById(R.id.rb_main);
        rb_scan= (RadioButton) findViewById(R.id.rb_scan);
        rb_shop_cart= (RadioButton) findViewById(R.id.rb_shop_cart);
        rb_user_center= (RadioButton) findViewById(R.id.rb_user_center);

//        rb_main.setBackgroundResource(R.drawable.selector_rbtn_main);
//        rb_scan.setBackgroundResource(R.drawable.selector_rbtn_scan);
//        rb_shop_cart.setBackgroundResource(R.drawable.selector_rbtn_shop);
//        rb_user_center.setBackgroundResource(R.drawable.selector_rbtn_user_center);

    }
}
