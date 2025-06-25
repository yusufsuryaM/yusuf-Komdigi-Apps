package com.yusuf0080.komdigiapps.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_preference")

class SettingsDataStore(private val context: Context) {

    val layoutFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_LIST] ?: true
    }

    suspend fun saveLayout(isList: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LIST] = isList
        }
    }

    val loggedInUserId: Flow<Int?>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_LOGGED_IN_USER_ID]
        }

    suspend fun saveLoggedInUserId(userId: Int) {
        context.dataStore.edit { preferences ->
            preferences[KEY_LOGGED_IN_USER_ID] = userId
        }
    }

    suspend fun clearLoggedInUser() {
        context.dataStore.edit { preferences ->
            preferences.remove(KEY_LOGGED_IN_USER_ID)
        }
    }

    companion object {
        private val IS_LIST = booleanPreferencesKey("is_list")
        private val KEY_LOGGED_IN_USER_ID = intPreferencesKey("logged_in_user_id")
    }
}