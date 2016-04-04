package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.util.Constant;

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

        Intent intent;

        switch (view.getId()) {
            case R.id.btn_doc:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.DOC.getVal());
                startActivity(intent);

                break;
            case R.id.btn_ppt:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.PPT.getVal());
                startActivity(intent);

                break;
            case R.id.btn_xls:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.XLS.getVal());
                startActivity(intent);

                break;
            case R.id.btn_pdf:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.PDF.getVal());
                startActivity(intent);

                break;
            case R.id.btn_txt:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.TXT.getVal());
                startActivity(intent);

                break;
            case R.id.btn_other:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.OTHER.getVal());
                startActivity(intent);
                break;
            case R.id.btn_category:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.LOCAL.getVal());
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
