package com.asalcedo.demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MapScreen(navController: NavHostController) {
    Column {
        Text(text = "Map Screen", style = MaterialTheme.typography.titleLarge)
    }
}