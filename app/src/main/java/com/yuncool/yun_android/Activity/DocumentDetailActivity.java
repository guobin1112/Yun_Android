package com.yuncool.yun_android.Activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.DocumentModel;

public class DocumentDetailActivity extends BaseActivity {


    DocumentModel documentModel;

    TextView tvDocument;
    Button btnPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_detail);

        documentModel = getIntent().getParcelableExtra("document");
        tvDocument = (TextView) findViewById(R.id.tv_document);
        btnPrint = (Button) findViewById(R.id.btn_print);

        if (documentModel != null) {

            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.setTitle(documentModel.documentTitle);
            }

            tvDocument.setText(documentModel.documentDetail);
            btnPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DocumentDetailActivity.this, "提交【" + documentModel.documentTitle + "】成功，快去打印吧！", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
}
