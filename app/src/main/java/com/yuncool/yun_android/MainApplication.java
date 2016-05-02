package com.yuncool.yun_android;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.yuncool.yun_android.model.UserInfoModel;

/**
 * Created by Black on 2016/2/13.
 */
public class MainApplication extends Application {

    private static SharedPreferences prefUserInfo;
    private static SharedPreferences.Editor editorUserInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        prefUserInfo = getSharedPreferences("UserInfo", MODE_PRIVATE);
        editorUserInfo = getSharedPreferences("UserInfo",
                MODE_PRIVATE).edit();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    public static UserInfoModel getLoginUserInfo() {

        String userInfo = prefUserInfo.getString("userInfo", "");

        return new Gson().fromJson(userInfo, UserInfoModel.class);
    }

    public static void setLoginUserInfo(UserInfoModel model) {

        editorUserInfo.putString("userInfo", new Gson().toJson(model));
        editorUserInfo.commit();

    }

}
