package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class Activity1Activity extends BaseActivity {

    Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        btnApply = (Button) findViewById(R.id.btn_apply);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity1Activity.this, "你已报名成功！", Toast.LENGTH_SHORT).show();
                btnApply.setText("已 报 名");
                btnApply.setBackgroundColor(getResources().getColor(R.color.colorTextHint));
            }
        });

    }
}
