package com.example.androidinterview;

import com.example.androidinterview.data.DataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/get")
    Call<ArrayList<DataModel>> getAllData();
}