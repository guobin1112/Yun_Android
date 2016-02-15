package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.MicroLibAdapter;
import com.yuncool.yun_android.view.MarginRightDividerDecoration;

import java.util.ArrayList;
import java.util.List;

public class MicroLibraryActivity extends BaseActivity {

    private EditText et_search;
    private TextView tv_yun_money_number;
    private RecyclerView rv_micro_lib;

    MicroLibAdapter adapter;
    List<String> list = new ArrayList<>();

    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mircro_library);

        initData();
        initView();
        initEvent();

    }


    private void initData() {

        list.add("考研类");
        list.add("外语类");
        list.add("实验类");
        list.add("生活类");
        list.add("数学类");
        list.add("考证类");
    }

    private void initView() {

        et_search = (EditText) findViewById(R.id.et_search);
        tv_yun_money_number = (TextView) findViewById(R.id.tv_yun_money_number);
        rv_micro_lib = (RecyclerView) findViewById(R.id.rv_micro_lib);

        adapter = new MicroLibAdapter(list);

        layoutManager = new LinearLayoutManager(this);
        rv_micro_lib.setLayoutManager(layoutManager);
        rv_micro_lib.setAdapter(adapter);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        int densityDpi = metric.densityDpi;

        rv_micro_lib.addItemDecoration(new MarginRightDividerDecoration((int) (108 * densityDpi / 320)));

    }

    private void initEvent() {

    }
}
