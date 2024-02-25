package com.team99.exerciserhony.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.team99.exerciserhony.ui.screen.propertydetail.PropertyDetailScreen
import com.team99.exerciserhony.ui.screen.propertylist.PropertyListScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.PropertyList.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.PropertyList.route) {
            PropertyListScreen(
                onOpenPropertyDetail = {
                    navController.navigate(NavigationItem.PropertyDetail.route)
                }
            )
        }
        composable(NavigationItem.PropertyDetail.route) {
            PropertyDetailScreen()
        }
    }
}
