package com.example.restApis.services

import com.example.restApis.models.UserInfo
import com.example.restApis.repositories.IUserRepository
import kotlinx.coroutines.*


class UserService(private val userRepository: IUserRepository) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    suspend fun fetchAllUsers(): List<UserInfo> {
        return userRepository.fetchAllUsers()
    }

    suspend fun fetchUserByEmail(email: String): Any? {

        val user = coroutineScope.async {
            userRepository.fetchUser(email)
        }
        return user.await()
    }

    suspend fun addUser(email: String, password: String): Unit {
        userRepository.addUser(email, password)
    }

    suspend fun deleteUser(email: String): Int {
        return userRepository.deleteUser(email)
    }

}