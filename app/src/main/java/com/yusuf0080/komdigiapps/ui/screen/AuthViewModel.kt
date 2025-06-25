package com.yusuf0080.komdigiapps.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf0080.komdigiapps.database.UserDao
import com.yusuf0080.komdigiapps.model.User
import com.yusuf0080.komdigiapps.util.SettingsDataStore
import kotlinx.coroutines.launch

class AuthViewModel(
    private val userDao: UserDao,
    private val settingsDataStore: SettingsDataStore
) : ViewModel() {

    fun registerUser(user: User, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val existingUser = userDao.findUserByUsername(user.username)
            if (existingUser != null) {
                onResult(false, "Username sudah digunakan.")
                return@launch
            }
            userDao.registerUser(user)
            onResult(true, "Registrasi berhasil!")
        }
    }

    fun login(username: String, pass: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userDao.findUserByUsername(username)
            if (user != null && user.password == pass) {
                settingsDataStore.saveLoggedInUserId(user.id)
                onResult(true)
            } else {
                onResult(false)
            }
        }
    }

    fun logout(onResult: () -> Unit) {
        viewModelScope.launch {
            settingsDataStore.clearLoggedInUser()
            onResult()
        }
    }
}