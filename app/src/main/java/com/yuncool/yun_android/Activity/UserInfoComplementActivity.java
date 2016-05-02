package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.UserInfoModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;

public class UserInfoComplementActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_name, et_address, et_telephone;
    private Button btn_birthday, btn_save;
    private RadioGroup rg_gender;

    private UserInfoModel userInfoModel;
    private int mGender = 0;

    private YunSQLiteHelper yunSQLiteHelper;
    private boolean isFirstUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_complement);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

        yunSQLiteHelper = new YunSQLiteHelper(this);

        SharedPreferences pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
        String userInfo = pref.getString("userInfo", "");

        userInfoModel = new Gson().fromJson(userInfo, UserInfoModel.class);
    }

    private void initView() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_address = (EditText) findViewById(R.id.et_address);
        et_telephone = (EditText) findViewById(R.id.et_telephone);
        btn_birthday = (Button) findViewById(R.id.btn_birthday);
        btn_save = (Button) findViewById(R.id.btn_save);
        rg_gender = (RadioGroup) findViewById(R.id.rg_gender);

        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_male:
                        mGender = UserInfoModel.MALE;
                        break;
                    case R.id.rb_female:
                        mGender = UserInfoModel.FEMALE;
                        break;
                }
            }
        });

        if (!userInfoModel.phoneNumber.equals("")) {
            isFirstUpdate = true;
            et_name.setText(userInfoModel.realName);
            et_address.setText(userInfoModel.address);
            et_telephone.setText(userInfoModel.phoneNumber);
            switch (userInfoModel.gender) {
                case R.id.rb_male:
                    rg_gender.check(R.id.rb_male);
                    break;
                case R.id.rb_female:
                    rg_gender.check(R.id.rb_female);
                    break;
            }
        }

    }

    private void initEvent() {

        btn_birthday.setOnClickListener(this);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:

                if (TextUtils.isEmpty(et_name.getText().toString())) {

                    Toast.makeText(UserInfoComplementActivity.this, "请输入您的名字", Toast.LENGTH_SHORT).show();

                } else if (mGender <= 0) {

                    Toast.makeText(UserInfoComplementActivity.this, "请选择您的性别", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(et_telephone.getText().toString())) {

                    Toast.makeText(UserInfoComplementActivity.this, "请输入您的手机号码", Toast.LENGTH_SHORT).show();
                } else if (et_telephone.getText().toString().length() != 11) {

                    Toast.makeText(UserInfoComplementActivity.this, "请输入有效的手机号码", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(et_address.getText().toString())) {

                    Toast.makeText(UserInfoComplementActivity.this, "请输入您的详细地址", Toast.LENGTH_SHORT).show();
                } else {

                    showProgressDialog();
                    if (yunSQLiteHelper.updateUserInfo(userInfoModel.userId, et_name.getText().toString(),
                            mGender, et_telephone.getText().toString(), et_address.getText().toString(), isFirstUpdate) > 0) {
                        Toast.makeText(UserInfoComplementActivity.this, "完善信息成功，云币+10", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(UserInfoComplementActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(UserInfoComplementActivity.this, "修改个人信息失败，请确保您输入的信息正确",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                break;
        }
    }
}
