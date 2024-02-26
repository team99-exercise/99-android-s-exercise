package com.team99.exerciserhony.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.team99.exerciserhony.ui.screen.propertydetail.PropertyDetailScreen
import com.team99.exerciserhony.ui.screen.propertylist.PropertyListFragment

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.PropertyList.route
    ) {
        composable(NavigationItem.PropertyList.route) {
            PropertyListFragment(navController = navController)
        }
        composable(NavigationItem.PropertyDetail.route) {
            PropertyDetailScreen()
        }
    }
}
