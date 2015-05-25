package com.jacmobile.productlookup.network.service;

import com.jacmobile.productlookup.network.model.WalmartQuery;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WalmartService
{
    @GET("/search?&format=json&apiKey=p8rh8kdrt9f7tqpkvazj2j5z")
    void searchWalmart(@Query("query") String query, Callback<WalmartQuery> callback);

    @GET("/trends?&format=json&apiKey=p8rh8kdrt9f7tqpkvazj2j5z")
    void walmartTrends(Callback<WalmartQuery> callback);
}