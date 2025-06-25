package com.yusuf0080.komdigiapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.yusuf0080.komdigiapps.util.SettingsDataStore
import com.yusuf0080.komdigiapps.navigation.Screen
import com.yusuf0080.komdigiapps.navigation.SetupNavGraph
import com.yusuf0080.komdigiapps.ui.theme.KomdigiAppsTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var startDestination by mutableStateOf<String?>(null)

        lifecycleScope.launch {
            val settingsDataStore = SettingsDataStore(applicationContext)
            val loggedInUserId = settingsDataStore.loggedInUserId.first()

            startDestination = if (loggedInUserId != null) {
                Screen.Home.route
            } else {
                Screen.Login.route
            }
        }

        installSplashScreen().setKeepOnScreenCondition {
            startDestination == null
        }

        setContent {
            KomdigiAppsTheme {
                startDestination?.let { destination ->
                    val navController = rememberNavController()
                    SetupNavGraph(
                        navController = navController,
                        startDestination = destination
                    )
                }
            }
        }
    }
}