package com.yuncool.yun_android.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.util.YunSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class RechargeOnlineActivity extends BaseActivity {

    private RadioGroup rg_recharge_online;
    private RadioButton rb_recharge, rb_pay_by_friend, rb_open_service;
    private RadioButton rb_10, rb_20, rb_100, rb_other;
    private ImageView iv_banner;
    private EditText et_account;
    private TextView tv_money_left_number, tv_pay_money_number, tv_discount_info;
    private Button btn_recharge;

    private List<Integer> list = new ArrayList<>();

    private YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_online);

        initData();
        initView();
        initEvent();

    }

    private void initData() {

    }

    private void initView() {

        rg_recharge_online = (RadioGroup) findViewById(R.id.rg_recharge_online);
        rb_recharge = (RadioButton) findViewById(R.id.rb_recharge);
        rb_pay_by_friend = (RadioButton) findViewById(R.id.rb_pay_by_friend);
        rb_open_service = (RadioButton) findViewById(R.id.rb_open_service);
        iv_banner = (ImageView) findViewById(R.id.iv_banner);
        et_account = (EditText) findViewById(R.id.et_account);
        tv_money_left_number = (TextView) findViewById(R.id.tv_money_left_number);
        tv_pay_money_number = (TextView) findViewById(R.id.tv_pay_money_number);
        tv_discount_info = (TextView) findViewById(R.id.tv_discount_info);
        btn_recharge = (Button) findViewById(R.id.btn_recharge);
        rb_10 = (RadioButton) findViewById(R.id.rb_10);
        rb_20 = (RadioButton) findViewById(R.id.rb_20);
        rb_100 = (RadioButton) findViewById(R.id.rb_100);
        rb_other = (RadioButton) findViewById(R.id.rb_other);

        rb_recharge.setChecked(true);

        rb_10.setChecked(true);

        yunSQLiteHelper = new YunSQLiteHelper(this);

    }

    private void initEvent() {

        btn_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(RechargeOnlineActivity.this)
                        .setTitle(R.string.app_name)
                        .setMessage("你确定要为账号" + et_account.getText().toString().trim()
                                + "充值10云币吗?")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (yunSQLiteHelper.addMoney(MainApplication.getLoginUserInfo().userId, 10) > 0) {
                                    Toast.makeText(RechargeOnlineActivity.this, "你已成功充值10云币", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(RechargeOnlineActivity.this, "充值失败啦，退出再试试吧", Toast.LENGTH_SHORT).show();
                                }
                                ;
                            }
                        })
                        .setPositiveButton("取消", null)
                        .show();
            }
        });
    }
}
