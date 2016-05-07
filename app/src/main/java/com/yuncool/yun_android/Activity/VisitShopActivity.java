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

        modelList.add(new ShopModel(0, R.drawable.shop_1, "华莱士", "西湖区", "小和山店", "留和路300号", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_2, "正宗重庆万州烤鱼", "西湖区", "古荡店", "文三西路古翠路口", "13512345678", 10f));
        ;
        modelList.add(new ShopModel(0, R.drawable.shop_3, "暗香盛宴中餐厅", "江干区", "笕桥店", "机场路250号创意达园内", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_4, "伤心酸辣粉", "余杭区", "临平店", "世纪大道1009号", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_5, "浪漫时光韩式自助餐厅", "西湖区", "骆家庄店", "骆家庄南公交车站", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_6, "舌尖上的烤鱼", "西湖区", "留下店", "留下街道和家园内", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_7, "晓德自助火锅", "萧山区", "萧山店", "", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_8, "陆老爹猪脚", "拱墅区", "萍水西街店", "萍水西街竞舟北路口", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_1, "华莱士", "西湖区", "小和山店", "留和路300号", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_2, "正宗重庆万州烤鱼", "西湖区", "古荡店", "文三西路古翠路口", "13512345678", 10f));
        ;
        modelList.add(new ShopModel(0, R.drawable.shop_3, "暗香盛宴中餐厅", "江干区", "笕桥店", "机场路250号创意达园内", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_4, "伤心酸辣粉", "余杭区", "临平店", "世纪大道1009号", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_5, "浪漫时光韩式自助餐厅", "西湖区", "骆家庄店", "骆家庄南公交车站", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_6, "舌尖上的烤鱼", "西湖区", "留下店", "留下街道和家园内", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_7, "晓德自助火锅", "萧山区", "萧山店", "", "13512345678", 10f));
        modelList.add(new ShopModel(0, R.drawable.shop_8, "陆老爹猪脚", "拱墅区", "萍水西街店", "萍水西街竞舟北路口", "13512345678", 10f));

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
                    intent.putExtra("shopInfo", modelList.get(position));
                    startActivity(intent);
                } else {
                    Toast.makeText(VisitShopActivity.this, "访问店铺出了点小问题，再试试看", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

}
