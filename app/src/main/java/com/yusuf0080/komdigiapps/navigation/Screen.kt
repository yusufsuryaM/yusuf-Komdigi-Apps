package com.yusuf0080.komdigiapps.navigation

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
}