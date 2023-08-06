package com.example.tweetsymvvm.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tweetsymvvm.R

@Composable
fun CategoryScreen(onclick : (email: String)-> Unit){
Column() {
    CategoryItem(category = "Fun Tweets", onclick = { onclick("hello i am fun tweet email") })
    CategoryItem(category = "Android Tweets", onclick = {onclick("hello i am android tweets email")})
}
}

@Composable
fun CategoryItem(category: String, onclick :()-> Unit){
    Box(
        modifier = Modifier
            .clickable { }
            .padding(4.dp)
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painterResource(
                    id = R.drawable.wave_haikei,
                ),

//                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color(0xFFEEEEEE)),
    contentAlignment = Alignment.BottomCenter

    ){
        Text(text = category,
        color = Color.Black,
            modifier = Modifier.padding(0.dp,20.dp),
            style = MaterialTheme.typography.bodyLarge
            )
    }
}