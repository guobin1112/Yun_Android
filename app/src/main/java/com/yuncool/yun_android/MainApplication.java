package com.yuncool.yun_android;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Black on 2016/2/13.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
