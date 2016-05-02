package com.yuncool.yun_android.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by Black on 2016/1/20.
 */
public class BaseActivity extends Activity {

    private ProgressDialog mProgressDialog;

    class ProgressThread extends Thread {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //所有页面都竖屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showProgressDialog() {

//        try {
//
//            if (mProgressDialog == null) {
//                mProgressDialog = new ProgressDialog(this);
//                mProgressDialog.setMessage("数据正在加载中，请稍后");
//            }
//
//            mProgressDialog.show();
//
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    mProgressDialog.dismiss();
//                }
//
//            }, new Random().nextInt(1000));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


}
