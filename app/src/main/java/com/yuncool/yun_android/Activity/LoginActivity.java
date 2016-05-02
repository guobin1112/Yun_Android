package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.UserInfoModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;

public class LoginActivity extends BaseActivity {

    Button btnLogin;
    TextView tvRegister;
    EditText etAccount, etPassword;

    YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        yunSQLiteHelper = new YunSQLiteHelper(this);

        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);
        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etAccount.getText().toString())
                        || TextUtils.isEmpty(etPassword.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                }

                showProgressDialog();
                UserInfoModel model = yunSQLiteHelper.login(etAccount.getText().toString(), etPassword.getText().toString());

                if (model != null) {

                    SharedPreferences.Editor editor = getSharedPreferences("UserInfo",
                            MODE_PRIVATE).edit();
                    editor.putString("userInfo", new Gson().toJson(model));
                    editor.commit();

                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号和密码不匹配，请重新输入", Toast.LENGTH_SHORT).show();
                }


            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
