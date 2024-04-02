package com.example.jobdenin.dataModel

import android.app.Notification
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.jobdenin.R

//data class BottomNavigationItem(
//    val title: String,
//    val selectedIcon : ImageVector,
//    val unSelectedIcon : ImageVector,
//    val badgeCount : Int? = null,
//    val route :String
//
//)
sealed class BottomNavigationItem(
    val route: String,
    val title: String,
    val selectedIcon : ImageVector,
    val unSelectedIcon: ImageVector,
    val badgeCount : Int? = null
){
    object Home : BottomNavigationItem(
    title = "Home",
    selectedIcon = Icons.Filled.Home,
    unSelectedIcon = Icons.Outlined.Home,
    route = "home"
    )
    object Network : BottomNavigationItem(
    title = "My Network",
    selectedIcon = Icons.Filled.Create,
    unSelectedIcon = Icons.Outlined.Create,
    route = "network"
    )
    object Post : BottomNavigationItem(
    title = "Post",
    selectedIcon = Icons.Filled.AddCircle,
    unSelectedIcon = Icons.Outlined.AddCircle,
    route = "post"
    )
   object Notification : BottomNavigationItem(
    title = "Notification",
    selectedIcon = Icons.Filled.Notifications,
    unSelectedIcon = Icons.Outlined.Notifications,
    route = "notification"
    )
    object Jobs : BottomNavigationItem(
    title = "Jobs",
    selectedIcon = Icons.Filled.AccountBox,
    unSelectedIcon = Icons.Outlined.AccountBox,
    route = "jobs"
    )
}