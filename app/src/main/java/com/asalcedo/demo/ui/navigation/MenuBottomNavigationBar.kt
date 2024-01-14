package com.asalcedo.demo.ui.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.ui.navigation
 * Created by Alex Salcedo Silva on 12/1/24 at 17:16
 * All rights reserve 2022.
 ***/

@Composable
fun MenuBottomNavigationBar(navHostController: NavHostController) {
    val menuItems = listOf(
        ItemsMenu.HomeScreen,
        ItemsMenu.InfoScreen,
        ItemsMenu.MapScreen
    )

    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                NavigationBarItem(selected = false, onClick = { }, icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                })
            }
        }
    }
}