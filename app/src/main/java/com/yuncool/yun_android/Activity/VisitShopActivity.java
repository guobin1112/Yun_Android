package com.yuncool.yun_android.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.VisitShopAdapter;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.util.YunSQLiteHelper;
import com.yuncool.yun_android.view.GridSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class VisitShopActivity extends BaseActivity {

    private RecyclerView rv_visit_shop;

    private VisitShopAdapter adapter;

    private GridLayoutManager layoutManager;

    private List<ShopModel> modelList = new ArrayList<>();

    private YunSQLiteHelper yunSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_shop);

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

                showProgressDialog();

                if (yunSQLiteHelper.addMoney(MainApplication.getLoginUserInfo().userId, 5) > 0) {

                    MainApplication.setLoginUserInfo(yunSQLiteHelper.queryUserInfo(MainApplication.getLoginUserInfo().userId));

                    Toast.makeText(VisitShopActivity.this, "访问" + modelList.get(position).shopName + "成功，云币+5", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(VisitShopActivity.this, ShopDetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(VisitShopActivity.this, "访问店铺出了点小问题，再试试看", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

}
