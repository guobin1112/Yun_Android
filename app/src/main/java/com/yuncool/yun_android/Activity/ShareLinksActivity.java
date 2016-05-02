package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.ShareLinksAdapter;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class ShareLinksActivity extends BaseActivity {

    private RecyclerView rv_share_links;

    private ShareLinksAdapter adapter;

    private LinearLayoutManager layoutManager;

    private List<ShopModel> modelList = new ArrayList<>();


    YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_links);

        initData();
        initView();
        initEvent();
    }

    private void initData() {

        yunSQLiteHelper = new YunSQLiteHelper(this);

        modelList.add(new ShopModel("晓得自主火锅", "江干区", R.drawable.shop1));
        modelList.add(new ShopModel("陆老爹猪脚", "萧山区", R.drawable.shop2));
        modelList.add(new ShopModel("世纪联华屏峰连锁店", "西湖区", R.drawable.shop3));
        modelList.add(new ShopModel("零妹妹石马店", "西湖区", R.drawable.shop4));
        modelList.add(new ShopModel("杨铭宇黄焖鸡", "西湖区", R.drawable.shop5));
        modelList.add(new ShopModel("晓德自主火锅", "西湖区", R.drawable.shop6));
        modelList.add(new ShopModel("晓得自主火锅", "江干区", R.drawable.shop1));
        modelList.add(new ShopModel("陆老爹猪脚", "萧山区", R.drawable.shop2));
        modelList.add(new ShopModel("世纪联华屏峰连锁店", "西湖区", R.drawable.shop3));
        modelList.add(new ShopModel("零妹妹石马店", "西湖区", R.drawable.shop4));
        modelList.add(new ShopModel("杨铭宇黄焖鸡", "西湖区", R.drawable.shop5));
        modelList.add(new ShopModel("晓德自主火锅", "西湖区", R.drawable.shop6));

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
