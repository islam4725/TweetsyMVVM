package com.example.tweetsymvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsymvvm.model.TweetListModelItem
import com.example.tweetsymvvm.respository.TweetRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// view model is the brige between the view and model. it take the data from respositories.

@HiltViewModel
class AndroidTweetsViewModel @Inject constructor(val respository: TweetRespository) :ViewModel(){

val tweets : StateFlow<List<TweetListModelItem>>
    get() =respository.androidTweets


    init {
        viewModelScope.launch {
            respository.getAndroid()
        }
    }


}