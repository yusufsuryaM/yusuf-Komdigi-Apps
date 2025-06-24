package com.yusuf0080.komdigiapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yusuf0080.komdigiapps.navigation.SetupNavGraph
import com.yusuf0080.komdigiapps.ui.theme.KomdigiAppsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            KomdigiAppsTheme {
                SetupNavGraph()
            }
        }
    }
}