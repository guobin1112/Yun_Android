package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.ShareLinksAdapter;
import com.yuncool.yun_android.model.ShopModel;

import java.util.ArrayList;
import java.util.List;

public class ShareLinksActivity extends AppCompatActivity {

    private RecyclerView rv_share_links;

    private ShareLinksAdapter adapter;

    private LinearLayoutManager layoutManager;

    private List<ShopModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_links);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));
        modelList.add(new ShopModel("晓得自主火锅", "江干区"));

    }

    private void initView() {

        rv_share_links = (RecyclerView) findViewById(R.id.rv_share_links);

        layoutManager = new LinearLayoutManager(this);

        adapter = new ShareLinksAdapter(modelList);

        rv_share_links.setLayoutManager(layoutManager);
        rv_share_links.setAdapter(adapter);
    }

    private void initEvent() {

        adapter.setOnItemClickListener(new ShareLinksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ShareLinksActivity.this, ShopDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
