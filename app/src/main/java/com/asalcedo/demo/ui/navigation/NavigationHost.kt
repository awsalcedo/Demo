package com.asalcedo.demo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.asalcedo.demo.ui.navigation.NavScreen.SignupScreen
import com.asalcedo.demo.ui.navigation.NavScreen.WelcomeScreen
import com.asalcedo.demo.ui.navigation.NavScreen.LoginScreen
import com.asalcedo.demo.ui.navigation.NavScreen.HomeScreen
import com.asalcedo.demo.ui.navigation.NavScreen.InfoScreen
import com.asalcedo.demo.ui.navigation.NavScreen.MapScreen
import com.asalcedo.demo.ui.screens.home.HomeScreen
import com.asalcedo.demo.ui.screens.InfoScreen
import com.asalcedo.demo.ui.screens.MapScreen
import com.asalcedo.demo.ui.screens.login.LoginScreen
import com.asalcedo.demo.ui.screens.welcome.WelcomeScreen

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = WelcomeScreen.name) {
        // also pass navController to each screen so we can use navController in there
        composable(WelcomeScreen.name) { WelcomeScreen(navController) }
        composable(LoginScreen.name) { LoginScreen(navController) }
        composable(HomeScreen.name) { HomeScreen() }
        composable(InfoScreen.name) { InfoScreen(navController) }
        composable(SignupScreen.name) { InfoScreen(navController) }
        composable(MapScreen.name) { MapScreen(navController) }
    }
}


