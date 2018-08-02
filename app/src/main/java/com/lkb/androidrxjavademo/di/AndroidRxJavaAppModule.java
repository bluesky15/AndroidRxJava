package com.lkb.androidrxjavademo.di;


import android.content.Context;

import com.lkb.androidrxjavademo.service.MessageService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidRxJavaAppModule {
    private Context context;

    public AndroidRxJavaAppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    MessageService provideMessageService(Context context) {
        return new MessageService();
    }


}
