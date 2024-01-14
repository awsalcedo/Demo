package com.asalcedo.demo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddAlert
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.Map
import androidx.compose.ui.graphics.vector.ImageVector

/*sealed class ItemsMenu(val icon: Int, val title: String, val route: String) {
    object HomeScreen : ItemsMenu(R.drawable.home_24, "Data", "homeScreen")
    object InfoScreen : ItemsMenu(R.drawable.warning_amber_24, "Info", "infoScreen")
    object CameraScreen : ItemsMenu(R.drawable.baseline_camera_alt_24, "Camera", "cameraScreen")
    object LoginScreen : ItemsMenu(R.drawable.baseline_camera_alt_24, "Login", "loginScreen")

    object SignupScreen : ItemsMenu(R.drawable.baseline_camera_alt_24, "Sign Up", "signupScreen")
    object WelcomeScreen : ItemsMenu(R.drawable.baseline_camera_alt_24, "Welcome", "welcomeScreen")
    object MapScreen : ItemsMenu(R.drawable.baseline_map_24, "Map", "mapScreen")
}*/

sealed class ItemsMenu(val icon: ImageVector, val title: String, val route: String) {
    object HomeScreen : ItemsMenu(Icons.Outlined.Home, "Data", NavScreen.HomeScreen.name)
    object InfoScreen : ItemsMenu(Icons.Outlined.Info, "Info", NavScreen.InfoScreen.name)
    object CameraScreen : ItemsMenu(Icons.Outlined.Camera, "Camera", NavScreen.CameraScreen.name)
    object LoginScreen : ItemsMenu(Icons.Outlined.Login, "Login", NavScreen.LoginScreen.name)

    object SignupScreen : ItemsMenu(Icons.Outlined.AddAlert, "Sign Up", NavScreen.SignupScreen.name)
    object WelcomeScreen : ItemsMenu(Icons.Outlined.Apps, "Welcome", NavScreen.WelcomeScreen.name)
    object MapScreen : ItemsMenu(Icons.Outlined.Map, "Map", NavScreen.MapScreen.name)
}
