package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class EarnYunMoneyActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_search;
    private TextView tv_share, tv_favor, tv_scan, tv_sign_in;
    private RelativeLayout rl_complete_info, rl_recommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_yun_money);

        initData();
        initView();
        initEvent();

    }

    private void initData() {

    }

    private void initView() {

        et_search = (EditText) findViewById(R.id.et_search);
        tv_share = (TextView) findViewById(R.id.tv_share);
        tv_favor = (TextView) findViewById(R.id.tv_favor);
        tv_scan = (TextView) findViewById(R.id.tv_scan);
        tv_sign_in = (TextView) findViewById(R.id.tv_sign_in);
        rl_complete_info = (RelativeLayout) findViewById(R.id.rl_complete_info);
        rl_recommend = (RelativeLayout) findViewById(R.id.rl_recommend);

    }

    private void initEvent() {

        tv_share.setOnClickListener(this);
        tv_favor.setOnClickListener(this);
        tv_scan.setOnClickListener(this);
        tv_sign_in.setOnClickListener(this);
        rl_complete_info.setOnClickListener(this);
        rl_recommend.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.tv_share:

                intent = new Intent(EarnYunMoneyActivity.this, ShareLinksActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_favor:

                intent = new Intent(EarnYunMoneyActivity.this, VisitShopActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_scan:

                Toast.makeText(EarnYunMoneyActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_sign_in:

                intent = new Intent(EarnYunMoneyActivity.this, SignInActivity.class);
                startActivity(intent);

                break;
            case R.id.rl_complete_info:

                intent = new Intent(EarnYunMoneyActivity.this, UserInfoComplementActivity.class);
                startActivity(intent);

                break;
            case R.id.rl_recommend:

                intent = new Intent(EarnYunMoneyActivity.this, RecommendActivity.class);
                startActivity(intent);

                break;
        }
    }
}
