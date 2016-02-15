package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class PrintActivity extends BaseActivity implements View.OnClickListener {

    private ImageButton ib_my_document, ib_scan_or_code, ib_up_load_files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        initData();
        initView();
        initEvent();

    }

    private void initData() {

    }

    private void initView() {

        ib_my_document = (ImageButton) findViewById(R.id.ib_my_document);
        ib_scan_or_code = (ImageButton) findViewById(R.id.ib_scan_or_code);
        ib_up_load_files = (ImageButton) findViewById(R.id.ib_up_load_files);

    }

    private void initEvent() {

        ib_my_document.setOnClickListener(this);
        ib_scan_or_code.setOnClickListener(this);
        ib_up_load_files.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_my_document:

                //TODO
                Toast.makeText(PrintActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_scan_or_code:

                //TODO
                Toast.makeText(PrintActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.ib_up_load_files:

                //TODO
                Toast.makeText(PrintActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
