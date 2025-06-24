package com.yusuf0080.komdigiapps.navigation

import com.yusuf0080.komdigiapps.ui.screen.KEY_ID_CATATAN

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_CATATAN}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}