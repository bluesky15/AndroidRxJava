package com.lkb.androidrxjavademo.di;


import com.lkb.androidrxjavademo.MainActivity;
import com.lkb.androidrxjavademo.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AndroidRxJavaAppModule.class)
public interface AndroidRxJavaApplicationComponent {
    void inject(MainActivityViewModel viewModel);
}
