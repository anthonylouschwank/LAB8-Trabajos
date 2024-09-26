package com.uvg.rickandmorty.presentation.location.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uvg.rickandmorty.presentation.location.profile.LocationProfileRoute
import kotlinx.serialization.Serializable

@Serializable
data class LocationProfileDestination(
    val locationId: Int
)

fun NavController.navigateToLocationProfileScreen(
    locationId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = LocationProfileDestination(locationId = locationId),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.locationProfileScreen(
    onNavigateBack: () -> Unit
) {
    composable<LocationProfileDestination> { backStackEntry ->
        val destination: LocationProfileDestination = backStackEntry.toRoute()
        LocationProfileRoute(
            id = destination.locationId,
            onNavigateBack = onNavigateBack
        )
    }
}
