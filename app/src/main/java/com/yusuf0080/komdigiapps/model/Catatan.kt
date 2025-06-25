package com.yusuf0080.komdigiapps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "catatan")

data class Catatan(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val userId: Int,
    val judul: String,
    val catatan: String,
    val tanggal: String
)
