package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.widget.Button;

import com.yuncool.yun_android.R;

public class Activity1Activity extends BaseActivity {

    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        btnApply = (Button) findViewById(R.id.btn_apply);

    }
}
