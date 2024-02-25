package com.team99.exerciserhony.ui.screen.navigation

enum class Screen {
    PropertyList,
    PropertyDetail
}

sealed class NavigationItem(val route: String) {
    data object PropertyList : NavigationItem(Screen.PropertyList.name)
    data object PropertyDetail : NavigationItem(Screen.PropertyDetail.name)
}
