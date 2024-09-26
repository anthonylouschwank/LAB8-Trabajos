package com.uvg.rickandmorty.presentation.navigation

import androidx.compose.material3.BottomNavigation
import androidx.compose.material3.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People


enum class BottomNavItem(val icon: ImageVector, val label: String) {
    Characters(Icons.Default.People, "Characters"),
    Locations(Icons.Default.LocationOn, "Locations"),
    Profile(Icons.Default.Person, "Profile")
}

@Composable
fun RickAndMortyBottomNavigation(
    currentScreen: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    BottomNavigation {
        BottomNavItem.values().forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = item == currentScreen,
                onClick = { onItemSelected(item) }
            )
        }
    }
}


