package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class RecommendActivity extends BaseActivity implements View.OnClickListener {

    private ImageButton ib_wechat_friends, ib_weibo_friends, ib_wechat_circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        initData();
        initView();
        initEvent();

    }

    private void initData() {

    }

    private void initView() {

        ib_wechat_friends = (ImageButton) findViewById(R.id.ib_wechat_friends);
        ib_wechat_circle = (ImageButton) findViewById(R.id.ib_wechat_circle);
        ib_weibo_friends = (ImageButton) findViewById(R.id.ib_weibo_friends);

    }

    private void initEvent() {

        ib_wechat_friends.setOnClickListener(this);
        ib_weibo_friends.setOnClickListener(this);
        ib_wechat_circle.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.ib_wechat_friends:

                Toast.makeText(RecommendActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;

            case R.id.ib_weibo_friends:

                Toast.makeText(RecommendActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;

            case R.id.ib_wechat_circle:

                Toast.makeText(RecommendActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
