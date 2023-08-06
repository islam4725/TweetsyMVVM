package com.example.tweetsymvvm

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsymvvm.screen.AndroidTweetsScreen
import com.example.tweetsymvvm.screen.CategoryScreen
import com.example.tweetsymvvm.screen.FunTweetScreen

@Composable
fun App() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "CategoryScreen") {

        // if we also send to send argument or data to next actvity then we use argument.

        composable(route = "AndroidTweetsScreen/{email}/{category}", arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            },
            navArgument("category") {
                type = NavType.StringType
            }


        )) {
            AndroidTweetsScreen()
        }

        composable(route = "FunTweetsScreen") {
            FunTweetScreen()
        }

        composable(route = "CategoryScreen") {
            CategoryScreen {
                navController.navigate("")
            }
        }
    }

}