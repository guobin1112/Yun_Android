package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.yuncool.yun_android.R;

public class SocialActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_publish, tv_post_number, tv_talent_number;
    private ImageButton ib_talent, ib_sign_in;

    private TextView tvActivity1, tvActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

    }

    private void initView() {

        tv_publish = (TextView) findViewById(R.id.tv_publish);
        tv_post_number = (TextView) findViewById(R.id.tv_post_number);
        tv_talent_number = (TextView) findViewById(R.id.tv_talent_number);
        ib_talent = (ImageButton) findViewById(R.id.ib_talent);
        ib_sign_in = (ImageButton) findViewById(R.id.ib_sign_in);

        tvActivity1 = (TextView) findViewById(R.id.tv_activity_1);
        tvActivity2 = (TextView) findViewById(R.id.tv_activity_2);

    }

    private void initEvent() {

        tv_publish.setOnClickListener(this);
        ib_talent.setOnClickListener(this);
        ib_sign_in.setOnClickListener(this);

        tvActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SocialActivity.this, Activity1Activity.class);
                startActivity(intent);
            }
        });

        tvActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SocialActivity.this, Activity2Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.tv_publish:

//                Toast.makeText(SocialActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_post_number:

//                Toast.makeText(SocialActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_talent_number:

//                Toast.makeText(SocialActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_talent:

//                Toast.makeText(SocialActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_sign_in:

//                Toast.makeText(SocialActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();
//                intent = new Intent(SocialActivity.this, SignInActivity.class);
//                startActivity(intent);

                break;
        }
    }
}
