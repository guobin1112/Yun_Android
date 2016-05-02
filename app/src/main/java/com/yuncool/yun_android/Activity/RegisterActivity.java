package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.UserInfoModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;

public class RegisterActivity extends BaseActivity {

    EditText etTel, etPassword, etConfirmPassword;
    Button btnRegister;

    YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        yunSQLiteHelper = new YunSQLiteHelper(this);

        etTel = (EditText) findViewById(R.id.et_tel);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etTel.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etPassword.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (etPassword.getText().equals(etConfirmPassword.getText())) {
                    Toast.makeText(RegisterActivity.this, "两次密码不相同", Toast.LENGTH_SHORT).show();
                } else {

                    UserInfoModel model = new UserInfoModel();
                    model.userName = etTel.getText().toString();
                    model.password = etPassword.getText().toString();

                    showProgressDialog();

                    if (yunSQLiteHelper.register(model) > 0) {

                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = getSharedPreferences("UserInfo",
                                MODE_PRIVATE).edit();
                        editor.putString("userInfo", new Gson().toJson(yunSQLiteHelper.login(model.userName, model.password)));
                        editor.commit();

                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "数据无法响应，请退出重试", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
