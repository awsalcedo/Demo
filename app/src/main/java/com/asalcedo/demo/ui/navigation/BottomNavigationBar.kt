package com.asalcedo.demo.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalAnimationApi
@Composable
fun BottomNavigationBar(
    onItemClick: (String) -> Unit
) {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val items = listOf(
        BottomNavItem(
            "Home",
            ItemsMenu.HomeScreen.route,
            Icons.Default.Home
        ),
        BottomNavItem(
            "Info",
            ItemsMenu.InfoScreen.route,
            Icons.Default.List
        ),
        BottomNavItem(
            "Search",
            ItemsMenu.MapScreen.route,
            Icons.Default.Map
        )
    )
    BottomAppBar {
        NavigationBar {
            items.forEachIndexed { index, item ->
                key(item.name) {
                    val selected = selectedIndex == index
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            selectedIndex = index
                            onItemClick(item.route)
                        },
                        icon = {
                            AnimatedVisibility(
                                visible = selected,
                                enter = fadeIn() + scaleIn(
                                    animationSpec = spring(
                                        dampingRatio = Spring.DampingRatioLowBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                                )
                            ) {
                                Box(
                                    /*modifier = Modifier
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.background),*/
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .padding(
                                                vertical = 5.dp,
                                                horizontal = 10.dp
                                            )
                                            .size(18.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Icon(
                                            imageVector = item.icon,
                                            contentDescription = item.name,
                                            tint = if (selected) MaterialTheme.colorScheme.primary else Color.Gray.copy(
                                                alpha = 0.5f
                                            )
                                        )
                                        Divider(modifier = Modifier.width(5.dp))
                                        Text(
                                            text = item.name,
                                            fontSize = 12.sp,
                                            color = if (selected) MaterialTheme.colorScheme.primary else Color.Gray.copy(
                                                alpha = 0.5f
                                            )
                                        )
                                    }
                                }
                            }
                            AnimatedVisibility(
                                visible = !selected,
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                    tint = Color.Gray.copy(alpha = 0.5f)
                                )
                            }
                        })
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BottomNavigationBarPreview() {
    // Ejemplo de cómo se verá en la vista previa
    BottomNavigationBar(onItemClick = {})
}