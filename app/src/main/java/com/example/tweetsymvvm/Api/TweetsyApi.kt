package com.example.tweetsymvvm.Api

import com.example.tweetsymvvm.model.TweetListModelItem
import retrofit2.Response
import retrofit2.http.GET
// in this interface we will define our endpoint.
interface TweetsyApi {


    @GET("get_android.php")
    suspend fun getAndroidList() : Response<List<TweetListModelItem>>

    @GET("get_fun.php")
    suspend fun getFunList() : Response<List<TweetListModelItem>>
}