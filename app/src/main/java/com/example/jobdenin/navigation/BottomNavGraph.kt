package com.example.jobdenin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jobdenin.dataModel.BottomNavigationItem
import com.example.jobdenin.presentation.screens.*


@Composable
fun BottomNavGraph(navigationController : NavHostController){
    NavHost(
        navController = navigationController,
        startDestination = BottomNavigationItem.Home.route

        ){
        composable(
            route = BottomNavigationItem.Home.route
        ){
            // home screen
            HomeScreen()
        }
        composable(
            route = BottomNavigationItem.Jobs.route
        ){
            // jobs screen
            JobScreen()
        }
        composable(
            route = BottomNavigationItem.Network.route
        ){
            // Network screen
            NetworkScreen()
        }
        composable(
            route = BottomNavigationItem.Notification.route
        ){
            // notification screen
            NotificationScreen()
        }
        composable(
            route = BottomNavigationItem.Post.route
        ){
            // post screen
            PostScreen()
        }
    }
}