package com.lkb.androidrxjavademo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.lkb.androidrxjavademo.models.User;
import com.lkb.androidrxjavademo.service.JsonService;
import com.lkb.androidrxjavademo.service.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> msg = new MutableLiveData<>();
    RetrofitApi api = new RetrofitApi();

    public LiveData<String> getMessage() {
        JsonService service = RetrofitApi.getJsonService().create(JsonService.class);
        Call<User> call = service.getUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User s = response.body();
                msg.setValue(s.getTitle());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("ViewModel",t.getMessage());
            }
        });
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