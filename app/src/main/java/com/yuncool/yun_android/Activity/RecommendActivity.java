package com.yuncool.yun_android.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.util.YunSQLiteHelper;

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

                new AlertDialog.Builder(view.getContext())
                        .setTitle(R.string.app_name)
                        .setMessage("确认分享？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                YunSQLiteHelper yunSQLiteHelper = new YunSQLiteHelper(RecommendActivity.this);

                                if (yunSQLiteHelper.addMoney(MainApplication.getLoginUserInfo().userId, 10) > 0) {

                                    MainApplication.setLoginUserInfo(yunSQLiteHelper.queryUserInfo(MainApplication.getLoginUserInfo().userId));

                                    Toast.makeText(RecommendActivity.this, "分享成功，云币+10", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(RecommendActivity.this, "分享出了点小问题，再试试看", Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();


                break;

            case R.id.ib_wechat_circle:

                Toast.makeText(RecommendActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}
