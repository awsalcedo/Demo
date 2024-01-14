package com.asalcedo.demo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.asalcedo.demo.ui.navigation.ItemsMenu.*
import com.asalcedo.demo.ui.navigation.MenuBottomNavigationBar
import com.asalcedo.demo.ui.navigation.NavigationHost
import com.asalcedo.demo.ui.theme.AuthUITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthUITheme {
                /// Let just add navigation so users can go from one screen to another
                MainScreen()
            }
        }
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {

        MenuBottomNavigationBar(navController)
    }) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            NavigationHost(navController)
        }
    }

}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Observar el cambio de ruta actual
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Determinar si la ruta actual corresponde a HomeScreen
    val isHomeScreen = navBackStackEntry?.destination?.route == HomeScreen.route

    Scaffold(
        bottomBar = {
            if (isHomeScreen) {
                // Mostrar BottomNavigationBar solo en HomeScreen
                MenuBottomNavigationBar(navController)
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            // Utilizar NavigationHost para manejar las transiciones de pantalla
            NavigationHost(navController)
        }
    }
}

