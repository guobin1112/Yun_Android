package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.MicroLibListAdapter;
import com.yuncool.yun_android.model.MicroLibListItemModel;

import java.util.ArrayList;
import java.util.List;

public class MicroLibListActivity extends AppCompatActivity {

    RecyclerView rv_micro_lib_list;

    LinearLayoutManager layoutManager;

    MicroLibListAdapter adapter;

    List<MicroLibListItemModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_lib_list);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

        modelList.add(new MicroLibListItemModel("15", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("14", "May", "二重积分"));
        modelList.add(new MicroLibListItemModel("13", "May", "行列式"));
        modelList.add(new MicroLibListItemModel("12", "May", "拉格朗日定理"));
        modelList.add(new MicroLibListItemModel("11", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("9", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("8", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("7", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("6", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("5", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("4", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("3", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("2", "May", "微积分"));
        modelList.add(new MicroLibListItemModel("1", "May", "微积分"));

    }

    private void initView() {

        rv_micro_lib_list = (RecyclerView) findViewById(R.id.rv_micro_lib_list);

        layoutManager = new LinearLayoutManager(this);

        adapter = new MicroLibListAdapter(modelList);

        rv_micro_lib_list.setLayoutManager(layoutManager);
        rv_micro_lib_list.setAdapter(adapter);

    }

    private void initEvent() {

    }
}