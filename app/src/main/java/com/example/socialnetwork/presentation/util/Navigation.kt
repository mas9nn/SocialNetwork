package com.example.socialnetwork.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialnetwork.presentation.login.LoginScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.LoginScreen.route
    ){
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
    }
}