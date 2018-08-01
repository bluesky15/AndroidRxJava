package com.lkb.androidrxjavademo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> msg = new MutableLiveData<>();

    public LiveData<String> getMessage() {
        msg.setValue("Hello world");
        return msg;
    }

    public void changeLiveDataValue() {
        try {
            Thread.sleep(1000);
            msg.setValue("You changed me!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}