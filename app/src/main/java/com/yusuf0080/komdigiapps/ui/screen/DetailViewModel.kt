package com.yusuf0080.komdigiapps.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuf0080.komdigiapps.database.CatatanDao
import com.yusuf0080.komdigiapps.model.Catatan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: CatatanDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(judul: String, isi: String) {
        val catatan = Catatan(
            tanggal = formatter.format(Date()),
            judul = judul,
            catatan = isi
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(catatan)
        }
    }
    fun getCatatan(id: Long): Catatan? {
        return null
    }
}