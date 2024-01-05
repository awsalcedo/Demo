package com.asalcedo.bottomnavigationbarcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CameraScreen() {
    Column {
        Text(text = "Camera", style = MaterialTheme.typography.titleLarge)
    }
}