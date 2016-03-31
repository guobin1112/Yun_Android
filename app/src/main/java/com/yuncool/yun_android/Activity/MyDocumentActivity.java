package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;

public class MyDocumentActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_doc, btn_ppt, btn_xls, btn_pdf, btn_txt, btn_other, btn_category, btn_common_softwafe;
    private TextView tv_download, tv_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_document);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

    }

    private void initView() {

        btn_doc = (Button) findViewById(R.id.btn_doc);
        btn_ppt = (Button) findViewById(R.id.btn_ppt);
        btn_xls = (Button) findViewById(R.id.btn_xls);
        btn_pdf = (Button) findViewById(R.id.btn_pdf);
        btn_txt = (Button) findViewById(R.id.btn_txt);
        btn_other = (Button) findViewById(R.id.btn_other);
        btn_category = (Button) findViewById(R.id.btn_category);
        btn_common_softwafe = (Button) findViewById(R.id.btn_common_software);
        tv_download = (TextView) findViewById(R.id.tv_download);
        tv_print = (TextView) findViewById(R.id.tv_print);

    }

    private void initEvent() {

        btn_doc.setOnClickListener(this);
        btn_ppt.setOnClickListener(this);
        btn_xls.setOnClickListener(this);
        btn_pdf.setOnClickListener(this);
        btn_txt.setOnClickListener(this);
        btn_other.setOnClickListener(this);
        btn_category.setOnClickListener(this);
        btn_common_softwafe.setOnClickListener(this);
        tv_download.setOnClickListener(this);
        tv_print.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_doc:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_ppt:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_xls:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_pdf:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_txt:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_other:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_category:

                Intent intent = new Intent(MyDocumentActivity.this, LocalFilesActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_common_software:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_download:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_print:

                Toast.makeText(MyDocumentActivity.this, "正在开发中", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
