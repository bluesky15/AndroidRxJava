package com.lkb.androidrxjavademo;

import android.app.Application;

import com.lkb.androidrxjavademo.di.AndroidRxJavaAppModule;
import com.lkb.androidrxjavademo.di.AndroidRxJavaApplicationComponent;
import com.lkb.androidrxjavademo.di.DaggerAndroidRxJavaApplicationComponent;

public class AndroidRxJavaApplication extends Application {
    private static AndroidRxJavaApplication application;
    private AndroidRxJavaApplicationComponent androidRxJavaApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        androidRxJavaApplicationComponent = DaggerAndroidRxJavaApplicationComponent
                .builder()
                .androidRxJavaAppModule(new AndroidRxJavaAppModule(this))
                .build();
    }

    public static AndroidRxJavaApplication application() {
        return application;
    }
    public AndroidRxJavaApplicationComponent getAndroidRxJavaApplicationComponent(){
        return this.androidRxJavaApplicationComponent;
    }
}
