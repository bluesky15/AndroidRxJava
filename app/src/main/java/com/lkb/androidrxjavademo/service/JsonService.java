package com.lkb.androidrxjavademo.service;

import com.lkb.androidrxjavademo.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonService {
    @GET("todos/1")
    Call<User> getUser();
}
