package com.yusuf0080.komdigiapps.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf0080.komdigiapps.database.CatatanDao
import com.yusuf0080.komdigiapps.model.Catatan
import com.yusuf0080.komdigiapps.util.SettingsDataStore
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val dao: CatatanDao,
    private val dataStore: SettingsDataStore
) : ViewModel() {

    private val _data = MutableStateFlow<List<Catatan>>(emptyList())
    val data: StateFlow<List<Catatan>> = _data.asStateFlow()

    init {
        viewModelScope.launch {
            dataStore.loggedInUserId.collect { userId ->
                if (userId != null) {
                    dao.getCatatanForUser(userId).collect { catatanList ->
                        _data.value = catatanList
                    }
                } else {
                    _data.value = emptyList()
                }
            }
        }
    }
}