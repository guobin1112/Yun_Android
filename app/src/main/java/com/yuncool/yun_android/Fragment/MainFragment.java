package com.yuncool.yun_android.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.yuncool.yun_android.Activity.FavorableShopActivity;
import com.yuncool.yun_android.Activity.MicroLibraryActivity;
import com.yuncool.yun_android.Activity.PrintActivity;
import com.yuncool.yun_android.Activity.ScanActivity;
import com.yuncool.yun_android.Activity.SocialActivity;
import com.yuncool.yun_android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener {


    ImageButton ib_print, ib_micro_lib, ib_shop, ib_user_center, ib_social;

    public MainFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initData();
        initView(view);
        initEvent();

        view.setOnTouchListener(this);

        return view;
    }

    private void initData() {

    }

    private void initView(View view) {

        ib_print = (ImageButton) view.findViewById(R.id.ib_print);
        ib_micro_lib = (ImageButton) view.findViewById(R.id.ib_micro_lib);
        ib_shop = (ImageButton) view.findViewById(R.id.ib_shop);
        ib_user_center = (ImageButton) view.findViewById(R.id.ib_user_center);
        ib_social = (ImageButton) view.findViewById(R.id.ib_social);

    }

    private void initEvent() {

        ib_print.setOnClickListener(this);
        ib_micro_lib.setOnClickListener(this);
        ib_shop.setOnClickListener(this);
        ib_user_center.setOnClickListener(this);
        ib_social.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {

            case R.id.ib_print:

                intent = new Intent(getActivity(), PrintActivity.class);
                startActivity(intent);

                break;
            case R.id.ib_micro_lib:

                intent = new Intent(getActivity(), MicroLibraryActivity.class);
                startActivity(intent);

                break;
            case R.id.ib_shop:

                intent = new Intent(getActivity(), FavorableShopActivity.class);
                startActivity(intent);

                break;
            case R.id.ib_user_center:

                intent = new Intent(getActivity(), ScanActivity.class);
                startActivity(intent);

                break;
            case R.id.ib_social:

                intent = new Intent(getActivity(), SocialActivity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
