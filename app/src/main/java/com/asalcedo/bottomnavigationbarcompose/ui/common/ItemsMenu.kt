package com.asalcedo.bottomnavigationbarcompose.ui.common

import com.asalcedo.bottomnavigationbarcompose.R

sealed class ItemsMenu(val icon: Int, val title: String, val route: String) {
    object HomeScreen : ItemsMenu(R.drawable.home_24, "Data", "homeScreen")
    object InfoScreen : ItemsMenu(R.drawable.warning_amber_24, "Info", "infoScreen")
    object CameraScreen : ItemsMenu(R.drawable.baseline_camera_alt_24, "Camera", "cameraScreen")
    object MapScreen : ItemsMenu(R.drawable.baseline_map_24, "Map", "mapScreen")
}
