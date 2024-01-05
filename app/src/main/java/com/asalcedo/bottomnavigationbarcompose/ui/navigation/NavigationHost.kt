package com.asalcedo.bottomnavigationbarcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asalcedo.bottomnavigationbarcompose.ui.common.ItemsMenu.*
import com.asalcedo.bottomnavigationbarcompose.ui.screens.*

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeScreen.route) {
        composable(HomeScreen.route) { HomeScreen() }
        composable(InfoScreen.route) { InfoScreen() }
        composable(CameraScreen.route) { CameraScreen() }
        composable(MapScreen.route) { MapScreen() }
    }
}