package com.example.lab1.labthuyettrinh.navigationGraph


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
data object Home
@Serializable
data object Detail

@Composable
fun NavigationApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home,
        builder = {
            composable<Home>{
                HomeScreen(navController)
            }
            composable<Detail>{
                DetailScreen(navController)
            }
        }
    )
}
@Composable
fun HomeScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Home Screen", fontSize = 28.sp,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { navController.navigate(Detail) },
        ) {
            Text(text = "Go to Detail Screen", fontSize = 22.sp)
        }
    }
}

@Composable
fun DetailScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Detail Screen", fontSize=28.sp,
            modifier = Modifier.align(Alignment.TopCenter))
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { navController.navigate(Home) },
        ) {
            Text(text = "Go to Home Screen", fontSize= 22.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun NavigationAppPreview() {
    NavigationApp()
}