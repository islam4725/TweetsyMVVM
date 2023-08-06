package com.example.tweetsymvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsymvvm.model.TweetListModelItem
import com.example.tweetsymvvm.respository.TweetRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FunTweetsViewModel @Inject constructor(val respository: TweetRespository)  : ViewModel() {


    val funTweets : StateFlow<List<TweetListModelItem>>
        get() = respository.funTweets

    init {
        viewModelScope.launch {
            respository.getfun()
        }
    }

}