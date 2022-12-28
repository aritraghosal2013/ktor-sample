package com.example.restApis.services

import com.example.restApis.models.UserInfo
import com.example.restApis.repositories.IUserRepository


class UserService(private val userRepository: IUserRepository) {
    fun fetchAllUsers(): List<UserInfo> {
        return userRepository.fetchAllUsers()
    }

    fun fetchUserByEmail(email: String): Any {
        return userRepository.fetchUser(email)
    }

    fun addUser(email: String, password: String): Unit {
        userRepository.addUser(email, password)
        return
    }

    fun deleteUser(email: String): Unit {
        userRepository.deleteUser(email)
    }

}