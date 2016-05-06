package com.yuncool.yun_android.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.yuncool.yun_android.Activity.ShopDetailActivity;
import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.adapter.ShopAdapter;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.view.GridSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavorableShopsFragment extends BaseFragment implements View.OnTouchListener {


    private Spinner sp_location;
    private EditText et_search;
    private RecyclerView rv_shops;
    private ArrayAdapter<CharSequence> spAapter;
    private ShopAdapter rvAdapter;
    private TextView tvDiscount;

    GridLayoutManager layoutManager;

    private List<ShopModel> modelList = new ArrayList<>();

    public FavorableShopsFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorable_shops, container, false);

        initData();
        initView(view);
        initEvent();

        view.setOnTouchListener(this);

        return view;
    }

    private void initData() {

//        public ShopModel(int shopId, int shopImageResId, String shopName, String area,
//                String shopPartName, String shopAddress, String shopPhoneNumber, float discount) {
//

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

    private void initView(View view) {

        sp_location = (Spinner) view.findViewById(R.id.sp_location);
        et_search = (EditText) view.findViewById(R.id.et_search);
        rv_shops = (RecyclerView) view.findViewById(R.id.rv_shops);

        rvAdapter = new ShopAdapter(modelList);
        layoutManager = new GridLayoutManager(getActivity(), 2);

        rv_shops.setAdapter(rvAdapter);
        rv_shops.setLayoutManager(layoutManager);

        rv_shops.addItemDecoration(new GridSpaceItemDecoration(32));

        spAapter = ArrayAdapter.createFromResource(getActivity(), R.array.shop_location_array, R.layout.support_simple_spinner_dropdown_item);
        spAapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp_location.setAdapter(spAapter);

        tvDiscount = (TextView) view.findViewById(R.id.tv_discount);

        tvDiscount.setText((int) MainApplication.getLoginUserInfo().discount + "");
    }

    private void initEvent() {
        rvAdapter.setOnItemClickListener(new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
                intent.putExtra("shopInfo", modelList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
