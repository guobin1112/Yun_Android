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

import com.yuncool.yun_android.Activity.ShopDetailActivity;
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
        modelList.add(new ShopModel(R.drawable.shop_1, "华莱士"));
        modelList.add(new ShopModel(R.drawable.shop_2, "正宗重庆万州烤鱼"));
        modelList.add(new ShopModel(R.drawable.shop_3, "暗香盛宴中餐厅"));
        modelList.add(new ShopModel(R.drawable.shop_4, "伤心酸辣粉"));
        modelList.add(new ShopModel(R.drawable.shop_5, "浪漫时光韩式自助餐厅"));
        modelList.add(new ShopModel(R.drawable.shop_6, "舌尖上的烤鱼"));
        modelList.add(new ShopModel(R.drawable.shop_7, "晓德自助火锅"));
        modelList.add(new ShopModel(R.drawable.shop_8, "陆老爹猪脚"));
        modelList.add(new ShopModel(R.drawable.shop_1, "华莱士"));
        modelList.add(new ShopModel(R.drawable.shop_2, "正宗重庆万州烤鱼"));
        modelList.add(new ShopModel(R.drawable.shop_3, "暗香盛宴中餐厅"));
        modelList.add(new ShopModel(R.drawable.shop_4, "伤心酸辣粉"));
        modelList.add(new ShopModel(R.drawable.shop_5, "浪漫时光韩式自助餐厅"));
        modelList.add(new ShopModel(R.drawable.shop_6, "舌尖上的烤鱼"));
        modelList.add(new ShopModel(R.drawable.shop_7, "晓德自助火锅"));
        modelList.add(new ShopModel(R.drawable.shop_8, "陆老爹猪脚"));
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
    }

    private void initEvent() {
        rvAdapter.setOnItemClickListener(new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
