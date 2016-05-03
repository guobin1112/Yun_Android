package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.FileAdapter;
import com.yuncool.yun_android.model.FileModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class FileUploadActivity extends BaseActivity {

    RecyclerView rv_file;
    ImageView imageView;
    FileAdapter adapter;

    List<FileModel> modelList = new ArrayList<>();

    YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_upload);

        yunSQLiteHelper = new YunSQLiteHelper(this);

        rv_file = (RecyclerView) findViewById(R.id.rv_file);
        imageView = (ImageView) findViewById(R.id.iv_null);

        modelList = yunSQLiteHelper.getFileList(MainApplication.getLoginUserInfo().userId);

        if (modelList.size() > 0) {

            rv_file.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);

            adapter = new FileAdapter(modelList, FileUploadActivity.this);

            rv_file.setLayoutManager(new LinearLayoutManager(this));
            rv_file.setAdapter(adapter);

            Toast.makeText(FileUploadActivity.this, "您有" + modelList.size() + "个文档待打印，快去打印吧！"
                    , Toast.LENGTH_SHORT).show();

        } else {
            rv_file.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
