package com.yusuf0080.komdigiapps.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yusuf0080.komdigiapps.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun findUserByUsername(username: String): User?
}