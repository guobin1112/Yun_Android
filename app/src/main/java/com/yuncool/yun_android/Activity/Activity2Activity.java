package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class Activity2Activity extends BaseActivity {

    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        btnApply = (Button) findViewById(R.id.btn_apply);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2Activity.this, "活动还没开始，再等等吧", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
