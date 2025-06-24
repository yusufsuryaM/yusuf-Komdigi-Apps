package com.yusuf0080.komdigiapps.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf0080.komdigiapps.database.CatatanDao
import com.yusuf0080.komdigiapps.model.Catatan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: CatatanDao) : ViewModel() {

    val data: StateFlow<List<Catatan>> = dao.getCatatan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}