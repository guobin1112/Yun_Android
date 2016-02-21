package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.VisitShopAdapter;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.view.GridSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class VisitShopActivity extends AppCompatActivity {

    private RecyclerView rv_visit_shop;

    private VisitShopAdapter adapter;

    private GridLayoutManager layoutManager;

    private List<ShopModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_shop);

        initData();
        initView();
        initEvent();

    }

    private void initData() {

        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));
        modelList.add(new ShopModel("", ""));

    }

    private void initView() {

        rv_visit_shop = (RecyclerView) findViewById(R.id.rv_visit_shop);

        layoutManager = new GridLayoutManager(this, 2);

        adapter = new VisitShopAdapter(modelList);

        rv_visit_shop.setAdapter(adapter);
        rv_visit_shop.setLayoutManager(layoutManager);
        rv_visit_shop.addItemDecoration(new GridSpaceItemDecoration(32, 2));

    }

    private void initEvent() {

        adapter.setOnItemClickListener(new VisitShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(VisitShopActivity.this, ShopDetailActivity.class);
                startActivity(intent);
            }
        });

    }

}
