package com.yuncool.yun_android.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yuncool.yun_android.Activity.EarnYunMoneyActivity;
import com.yuncool.yun_android.Activity.RechargeOnlineActivity;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.UserInfoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCenterFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener {

    private ImageView iv_head_pic;
    private TextView tv_user_name, tv_account, tv_yun_money_number, tv_discount_number,
            tv_get_yun_money, tv_recharge_online;

    UserInfoModel userInfoModel;

    public UserCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_user_center, container, false);

        initData();
        initView(view);
        initEvent();

        view.setOnTouchListener(this);

        return view;
    }

    private void initView(View view) {

        iv_head_pic = (ImageView) view.findViewById(R.id.iv_head_pic);
        tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
        tv_account = (TextView) view.findViewById(R.id.tv_account);
        tv_yun_money_number = (TextView) view.findViewById(R.id.tv_yun_money_number);
        tv_discount_number = (TextView) view.findViewById(R.id.tv_discount_number);
        tv_get_yun_money = (TextView) view.findViewById(R.id.tv_get_yun_money);
        tv_recharge_online = (TextView) view.findViewById(R.id.tv_recharge_online);

        tv_user_name.setText(userInfoModel.userName);
        tv_account.setText(userInfoModel.phoneNumber);
        tv_yun_money_number.setText((int) userInfoModel.money + "");
        tv_discount_number.setText((int) userInfoModel.discount + "");

    }

    private void initData() {

        SharedPreferences pref = getActivity().getSharedPreferences("UserInfo", getActivity().MODE_PRIVATE);
        String userInfo = pref.getString("userInfo", "");

        userInfoModel = new Gson().fromJson(userInfo, UserInfoModel.class);


    }

    private void initEvent() {
        tv_get_yun_money.setOnClickListener(this);
        tv_recharge_online.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.tv_get_yun_money:

                intent = new Intent(getActivity(), EarnYunMoneyActivity.class);
                startActivity(intent);

                break;
            case R.id.tv_recharge_online:

                intent = new Intent(getActivity(), RechargeOnlineActivity.class);
                startActivity(intent);

                break;
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
