package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.ShopModel;

public class ShopDetailActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_search;
    private ImageView iv_shop_pic;
    private TextView tv_shop_name, tv_book, tv_days_left, tv_shop_branch_name, tv_shop_branch_address,
            tv_distance, tv_validate_time, tv_book_info, tv_rules, tv_service;
    private Button btn_action;
    private RatingBar rb_elevation;
    private ImageButton ib_shop_phone;

    private ShopModel shopModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        initData();
        initView();
        initEvent();
    }

    private void initData() {
        shopModel = getIntent().getParcelableExtra("shopInfo");
    }

    private void initView() {

        et_search = (EditText) findViewById(R.id.et_search);
        iv_shop_pic = (ImageView) findViewById(R.id.iv_shop_pic);
        tv_shop_name = (TextView) findViewById(R.id.tv_shop_name);
        tv_book = (TextView) findViewById(R.id.tv_book);
        tv_days_left = (TextView) findViewById(R.id.tv_days_left);
        tv_shop_branch_name = (TextView) findViewById(R.id.tv_shop_branch_name);
        tv_shop_branch_address = (TextView) findViewById(R.id.tv_shop_branch_address);
        tv_distance = (TextView) findViewById(R.id.tv_distance);
        tv_validate_time = (TextView) findViewById(R.id.tv_validate_time);
        tv_book_info = (TextView) findViewById(R.id.tv_book);
        tv_rules = (TextView) findViewById(R.id.tv_rules);
        tv_service = (TextView) findViewById(R.id.tv_service);
        btn_action = (Button) findViewById(R.id.btn_action);
        rb_elevation = (RatingBar) findViewById(R.id.rb_elevation);
        ib_shop_phone = (ImageButton) findViewById(R.id.ib_shop_phone);

        if (shopModel != null) {

            iv_shop_pic.setImageResource(shopModel.shopImageResId);
            tv_shop_name.setText(shopModel.shopName);
            tv_shop_branch_name.setText(shopModel.shopPartName);
            tv_shop_branch_address.setText(shopModel.shopAddress);

        } else {
            Toast.makeText(ShopDetailActivity.this, "数据无法响应", Toast.LENGTH_SHORT).show();
        }

    }

    private void initEvent() {

        btn_action.setOnClickListener(this);
        ib_shop_phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_action:

                Toast.makeText(ShopDetailActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_shop_phone:

                Toast.makeText(ShopDetailActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
