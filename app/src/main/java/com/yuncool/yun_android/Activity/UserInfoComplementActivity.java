package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class UserInfoComplementActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_name, et_address, et_telephone;
    private Button btn_birthday, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_complement);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

    }

    private void initView() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_address = (EditText) findViewById(R.id.et_address);
        et_telephone = (EditText) findViewById(R.id.et_telephone);
        btn_birthday = (Button) findViewById(R.id.btn_birthday);
        btn_save = (Button) findViewById(R.id.btn_save);

    }

    private void initEvent() {

        btn_birthday.setOnClickListener(this);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_birthday:

                Toast.makeText(UserInfoComplementActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_save:

                Toast.makeText(UserInfoComplementActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
