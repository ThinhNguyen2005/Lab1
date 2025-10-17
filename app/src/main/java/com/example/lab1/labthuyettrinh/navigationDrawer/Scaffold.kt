package com.example.lab1.labthuyettrinh.navigationDrawer

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.lab1.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerApp() { // Đổi tên hàm để mô tả đúng chức năng
    // --- KHAI BÁO CÁC STATE CẦN THIẾT ---
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Danh sách các mục trong drawer
    val navigationItems = listOf(
        NavigationDrawerItemInfo.Home,
        NavigationDrawerItemInfo.Shopping,
        NavigationDrawerItemInfo.Create,
        NavigationDrawerItemInfo.Notification,
        NavigationDrawerItemInfo.Account
    )

    // --- CẤU TRÚC GIAO DIỆN CHÍNH VỚI MODAL NAVIGATION DRAWER ---
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // --- NỘI DUNG CỦA DRAWER (MENU) ---
            ModalDrawerSheet {
                Spacer(Modifier.width(256.dp))
                navigationItems.forEach { item ->
                    val isSelected = currentDestination?.route == item.route::class.qualifiedName
                    NavigationDrawerItem(
                        icon = { Icon(if (isSelected) item.selectedIcon else item.unselectedIcon, contentDescription = null) },
                        label = { Text(item.label) },
                        selected = isSelected,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(item.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // re-selecting the same item
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }
    ) {
        // --- NỘI DUNG CHÍNH CỦA ỨNG DỤNG (SCAFFOLD VÀ NAVHOST) ---
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                startDestination = Destination.Home // Route bắt đầu
            ) {
                composable<Destination.Home> { ContentScreen(Destination.Home.label) }
                composable<Destination.Shopping> { ContentScreen(Destination.Shopping.label) }
                composable<Destination.Notification> { ContentScreen(Destination.Notification.label) }
                composable<Destination.Create> { ContentScreen(Destination.Create.label) }
                composable<Destination.Account> { ContentScreen(Destination.Account.label) }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDrawerAppPreview() {
    NavigationDrawerApp()
}