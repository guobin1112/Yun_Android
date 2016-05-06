package com.yuncool.yun_android.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.util.YunSQLiteHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends BaseFragment implements View.OnTouchListener {

    YunSQLiteHelper yunSQLiteHelper;

    public ScanFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        view.setOnTouchListener(this);

        yunSQLiteHelper = new YunSQLiteHelper(getActivity());

        if (yunSQLiteHelper.getFileList(MainApplication.getLoginUserInfo().userId).size() > 0) {
            Toast.makeText(getActivity(), "你有" + yunSQLiteHelper.getFileList(MainApplication.getLoginUserInfo().userId).size()
                    + "份文档代打印,快去附近打印吧！", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "你还没有文档需要打印，快去上传文档打印吧！", Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
