package com.example.restApis.repositories

import com.example.restApis.models.UserInfo

interface IUserRepository {

    fun fetchUser(email: String): Any
    fun fetchAllUsers(): List<UserInfo>
    fun addUser(email: String, password: String): Unit
    fun deleteUser(email: String): Unit
}