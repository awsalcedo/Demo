package com.asalcedo.demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun InfoScreen(navController: NavHostController) {
    Column {
        Text(text = "Info Screen", style = MaterialTheme.typography.titleLarge)
    }
}