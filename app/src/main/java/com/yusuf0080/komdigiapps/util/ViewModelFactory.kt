package com.yusuf0080.komdigiapps.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yusuf0080.komdigiapps.database.CatatanDb
import com.yusuf0080.komdigiapps.ui.screen.AuthViewModel
import com.yusuf0080.komdigiapps.ui.screen.DetailViewModel
import com.yusuf0080.komdigiapps.ui.screen.MainViewModel

class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = CatatanDb.getInstance(context)
        val dataStore = SettingsDataStore(context)

        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(database.dao, dataStore) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(database.dao) as T
            }
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> {
                AuthViewModel(database.userDao(), dataStore) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
