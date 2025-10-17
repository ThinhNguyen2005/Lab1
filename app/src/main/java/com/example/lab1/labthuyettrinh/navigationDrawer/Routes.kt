package com.example.lab1.labthuyettrinh.navigationDrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.* // Import tất cả icon Filled
import androidx.compose.material.icons.outlined.* // Import tất cả icon Outlined
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val label: String) {
    @Serializable
    data object Home : Destination("Home")
    @Serializable
    data object Shopping : Destination("Shopping")
    @Serializable
    data object Create : Destination("Create")
    @Serializable
    data object Notification : Destination("Notification")
    @Serializable
    data object Account : Destination("Account")
}

// SỬA LỖI: Đặt các data object vào BÊN TRONG sealed class
sealed class NavigationDrawerItemInfo(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: Destination
) {
    data object Home : NavigationDrawerItemInfo("Home", Icons.Filled.Home, Icons.Outlined.Home, Destination.Home)
    data object Shopping : NavigationDrawerItemInfo("Shopping", Icons.Filled.ShoppingCart, Icons.Outlined.ShoppingCart, Destination.Shopping)
    data object Create : NavigationDrawerItemInfo("Create", Icons.Filled.AddCircle, Icons.Outlined.AddCircle, Destination.Create)
    data object Notification : NavigationDrawerItemInfo("Notification", Icons.Filled.Notifications, Icons.Outlined.Notifications, Destination.Notification)
    data object Account : NavigationDrawerItemInfo("Account", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle, Destination.Account)
}