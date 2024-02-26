package com.team99.exerciserhony.ui.screen.navigation

import com.team99.exerciserhony.ui.screen.navigation.NavigationArguments.ARG_PROPERTY_ID

enum class Screen {
    PropertyList,
    PropertyDetail
}

sealed class NavigationRoute(val route: String) {
    data object PropertyList : NavigationRoute(Screen.PropertyList.name)
    data object PropertyDetail : NavigationRoute(
        route = "${Screen.PropertyDetail.name}/{$ARG_PROPERTY_ID}"
    ) {
        fun createRoute(id: Int) = "${Screen.PropertyDetail.name}/$id"
    }
}
