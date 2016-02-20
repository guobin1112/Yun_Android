package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.MoneyAdapter;

import java.util.ArrayList;
import java.util.List;

public class RechargeOnlineActivity extends BaseActivity {

    private RadioGroup rg_recharge_online;
    private RadioButton rb_recharge, rb_pay_by_friend, rb_open_service;
    private ImageView iv_banner;
    private EditText et_account;
    private TextView tv_money_left_number, tv_pay_money_number, tv_discount_info;
    private Button btn_recharge;
    private RecyclerView rv_money;

    private MoneyAdapter adapter;
    private GridLayoutManager layoutManager;

    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_online);

        initData();
        initView();
        initEvent();

    }

    private void initData() {
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(100));
        list.add(new Integer(-1));
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
        rv_money = (RecyclerView) findViewById(R.id.rv_money);

        adapter = new MoneyAdapter(list);
        layoutManager = new GridLayoutManager(this, 4);

        rv_money.setAdapter(adapter);
        rv_money.setLayoutManager(layoutManager);

    }

    private void initEvent() {

        adapter.setOnItemClickListener(new MoneyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                ToggleButton toggleButton = (ToggleButton) rv_money.getChildAt(position);

                if (!toggleButton.isChecked()) {
                    for (int i = 0; i < rv_money.getChildCount(); i++) {
                        if (i == position) {
                            toggleButton.setChecked(true);
                        } else {
                            toggleButton.setChecked(false);
                        }

                    }
                }

            }
        });

        btn_recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RechargeOnlineActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
