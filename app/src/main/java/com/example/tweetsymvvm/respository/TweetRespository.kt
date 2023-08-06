package com.example.tweetsymvvm.respository

import com.example.tweetsymvvm.Api.TweetsyApi
import com.example.tweetsymvvm.model.TweetListModelItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


//its give us data it may be api sourse may be local

class TweetRespository @Inject constructor(val tweetsyApi: TweetsyApi) {


    //you know mutable is change able we use it here only because we not want any other
    // componet can change our data.
    private val _fun = MutableStateFlow<List<TweetListModelItem>>(emptyList())

    // this is read only getfun for access any where.
    val funTweets :  StateFlow<List<TweetListModelItem>>
        get() = _fun


    private val _android = MutableStateFlow<List<TweetListModelItem>>(emptyList())
    val androidTweets : StateFlow<List<TweetListModelItem>>
        get() = _android

    suspend fun getfun() {
        val response = tweetsyApi.getFunList()
        if (response.isSuccessful && response.body() != null) {
            _fun.emit(response.body()!!)
        }

    }


    suspend fun getAndroid() {
        val response = tweetsyApi.getAndroidList()
        if (response.isSuccessful && response.body() != null) {
            _android.emit(response.body()!!)
        }

    }

}