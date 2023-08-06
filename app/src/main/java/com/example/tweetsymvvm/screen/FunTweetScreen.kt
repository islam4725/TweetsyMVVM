package com.example.tweetsymvvm.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsymvvm.viewmodel.FunTweetsViewModel

@Composable
fun FunTweetScreen() {

    val funViewModel: FunTweetsViewModel = viewModel()
//we use collect as state for observing the life data that is currently changing.
    val tweets = funViewModel.funTweets.collectAsState()

LazyColumn(content = {
    items(tweets.value){
        funTweetsItem(tweet = it.text,onclick)


    }
})
}

@Composable
fun funTweetsItem(tweet: String, onclick: (email: String) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),

        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = tweet,
                modifier = Modifier.clickable { onclick("islamshabbir13382@gmai.com") }.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    )
}