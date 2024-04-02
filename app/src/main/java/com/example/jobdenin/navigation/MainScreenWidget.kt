package com.example.jobdenin.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jobdenin.dataModel.BottomNavigationItem


@Composable
fun MainScreenWidget(){
    val navController  = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        BottomNavGraph(navigationController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Jobs,
        BottomNavigationItem.Notification,
        BottomNavigationItem.Post,
        BottomNavigationItem.Network
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(containerColor = Color.White) {
        screens.forEachIndexed { index, bottomNavigationItem ->
            AddItem(screen = bottomNavigationItem, currentDestination = currentDestination, navController = navController, selectedItemIndex = index )
        }
    }
    
}

@Composable
fun RowScope.AddItem(
    screen : BottomNavigationItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
    selectedItemIndex : Int
) {
    NavigationBarItem(selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        label = {
            Text(text = screen.title, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        },
        icon = {
            BadgedBox(badge = {
                if (screen.badgeCount != null) {
                    Badge {
                        Text(text = screen.badgeCount.toString())
                    }
                }
            }) {
                Icon(
                    imageVector = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                        screen.selectedIcon
                    } else {
                        screen.unSelectedIcon
                    },
                    contentDescription = screen.title
                )
            }
        })
}