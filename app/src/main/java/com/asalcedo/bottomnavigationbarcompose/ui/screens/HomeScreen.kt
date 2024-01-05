package com.asalcedo.bottomnavigationbarcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Column {
        Text(text = "Home", style = MaterialTheme.typography.titleLarge)
    }
}