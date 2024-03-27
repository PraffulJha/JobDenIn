package com.example.jobdenin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.jobdenin.dataModel.BottomNavigationItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                BottomNavigationItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unSelectedIcon = Icons.Outlined.Home
                ),
                BottomNavigationItem(
                    title = "My Network",
                    selectedIcon = Icons.Filled.Create,
                    unSelectedIcon = Icons.Outlined.Create
                ),
                BottomNavigationItem(
                    title = "Post",
                    selectedIcon = Icons.Filled.Add,
                    unSelectedIcon = Icons.Outlined.Add
                ),
                BottomNavigationItem(
                    title = "Notification",
                    selectedIcon = Icons.Filled.Face,
                    unSelectedIcon = Icons.Outlined.Face
                ),
                BottomNavigationItem(
                    title = "Settings",
                    selectedIcon = Icons.Filled.Settings,
                    unSelectedIcon = Icons.Outlined.Settings
                )
            )
            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }
           Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background
           ) {
               Scaffold(bottomBar = {
                   NavigationBar {
                       items.forEachIndexed { index, bottomNavigationItem -> 
                           NavigationBarItem(selected = selectedItemIndex == index, onClick = { selectedItemIndex = index },
                               label = {
                                       Text(text = bottomNavigationItem.title)
                               },
                               icon = {
                               BadgedBox(badge = {
                                   if(bottomNavigationItem.badgeCount != null){
                                       Badge{
                                           Text(text = bottomNavigationItem.badgeCount.toString())
                                       }
                                   }
                               }) {
                                   Icon(imageVector = if(index == selectedItemIndex){
                                       bottomNavigationItem.selectedIcon
                                   } else{
                                       bottomNavigationItem.unSelectedIcon
                                   },
                                   contentDescription = bottomNavigationItem.title)
                               }
                           })
                       }
                   }
               }){

               }
           }
        }
    }
}