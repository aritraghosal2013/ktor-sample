package com.example.restApis.repositories

import com.example.restApis.models.UserInfo

interface IUserRepository {

    suspend fun fetchUser(email: String): Any?
    suspend fun fetchAllUsers(): List<UserInfo>
    suspend fun addUser(email: String, password: String): Unit
    suspend fun deleteUser(email: String): Int
}