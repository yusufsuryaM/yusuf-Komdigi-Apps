package com.yusuf0080.komdigiapps.ui.screen

import androidx.lifecycle.ViewModel
import com.yusuf0080.komdigiapps.model.Catatan

class MainViewModel : ViewModel() {
    val data = listOf(
        Catatan(
            1,
            "Kuliah Mobpro 17 Feb",
            "Kuliah hari pertama. Ternyata keren juga yang mau dipelajari. Pengenalan tentang Android dan Kotlin sangat menarik untuk diperdalam.",
            "2025-02-17 12:34:56"
        ),
        Catatan(
            2,
            "Kuliah Mobpro 19 Feb",
            "Praktikum pertama: running modul. Alhamdulillah hari ini lancar. Sempat kesulitan dengan setup SDK tapi akhirnya bisa juga. Teman-teman sangat membantu.",
            "2025-02-19 12:34:56"
        ),
        Catatan(
            3,
            "Modul 01 - Introduction",
            "Belajar dasar-dasar Android dan struktur project. Mengenal Activity, Layout XML, dan cara kerja aplikasi Android. IDE Android Studio memang butuh spesifikasi tinggi.",
            "2025-02-22 14:30:25"
        ),
        Catatan(
            4,
            "Modul 02 - Build Your First App",
            "Hari ini praktikum membuat aplikasi pertama. Belajar cara membuat layout sederhana dan menambahkan fungsi pada button. Aplikasi Hello World berhasil dijalankan di emulator.",
            "2025-02-26 15:45:18"
        ),
        Catatan(
            5,
            "Modul 03 - Working with Images",
            "Praktikum menampilkan dan memanipulasi gambar di aplikasi Android. ImageView library sangat membantu. Berhasil membuat galeri sederhana dengan beberapa foto.",
            "2025-03-01 10:20:37"
        ),
        Catatan(
            6,
            "Kuliah Mobpro 05 Mar",
            "Praktikum kali ini bikin aplikasi Galeri Hewan. Klik tombol lanjut, maka foto dan nama hewannya berubah. Sangat interaktif dan menyenangkan untuk diimplementasikan.",
            "2025-03-05 12:34:56"
        ),
        Catatan(
            7,
            "Modul 04 - Get User Input",
            "Mempelajari cara mengambil input dari user menggunakan EditText dan form. Membuat validasi input dan menampilkan pesan error. Form registrasi sederhana sudah berhasil dibuat.",
            "2025-03-09 13:15:42"
        ),
        Catatan(
            8,
            "Modul 05 - App Navigation",
            "Belajar implementasi navigasi antar halaman dengan Intent. Explicit dan Implicit Intent sangat berguna untuk berbagai kasus. Sudah bisa mengirim data antar Activity.",
            "2025-03-15 16:22:33"
        )
    )
    fun getCatatan(id: Long): Catatan? {
        return data.find { it.id == id }
    }
}