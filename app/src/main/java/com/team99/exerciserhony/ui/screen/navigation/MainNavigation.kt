package com.team99.exerciserhony.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.team99.exerciserhony.ui.screen.propertydetail.PropertyDetailFragment
import com.team99.exerciserhony.ui.screen.propertylist.PropertyListFragment

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.PropertyList.route
    ) {
        composable(NavigationRoute.PropertyList.route) {
            PropertyListFragment(navController = navController)
        }
        composable(
            route = NavigationRoute.PropertyDetail.route,
            arguments = listOf(
                navArgument(NavigationArguments.ARG_PROPERTY_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            PropertyDetailFragment(
                propId = backStackEntry.arguments?.getInt(NavigationArguments.ARG_PROPERTY_ID)!!,
                navController = navController
            )
        }
    }
}
