package com.example.location.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.location.ui.components.TopAppBar
import com.example.location.ui.screens.HomeScreen
import com.example.location.ui.screens.LocationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AppNavigation() {
    val navController = rememberNavController()
    val currentBackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackEntry.value?.destination?.route

    val routeTitles = mapOf(
        "home" to "Home",
        "location" to "Location"
    )
    val currentTitle = routeTitles[currentRoute] ?: "App"

    Scaffold(
        topBar = {
            TopAppBar(
                title = currentTitle,
                canNavigateBack = currentRoute != "home",
                onBackClick = { navController.popBackStack() },
                onMenuItemClick = { route ->
                    navController.navigate(route)
                }
            )}
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = "home",
            Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("location") { LocationScreen(navController) }
        }
    }
}

