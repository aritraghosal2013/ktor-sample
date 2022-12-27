package com.example.restApis.repositories

import com.example.restApis.models.UserInfo

class UserRepository: IUserRepository {
    companion object {
        val usersList = mutableListOf<UserInfo>()
    }

    init {
        // Adding initial users
        usersList.add(UserInfo("aritraghosal2013@gmail.com", "password"))
        usersList.add(UserInfo("mikel.obi2013@gmail.com", "password"))
        usersList.add(UserInfo("joseph.mcjosh2013@gmail.com", "password"))
        usersList.add(UserInfo("alex.macarthy2013@gmail.com", "password"))

    }
    override fun fetchUser(email: String): UserInfo {
        println("Fetching user with email id: $email")
        return usersList.filter { it.email == email }[0] ?: UserInfo("Default", "Default")
    }

    override fun fetchAllUsers(): List<UserInfo> {
        println("Fetching all users")
        return usersList
    }

    override fun addUser(email: String, password: String): Unit {
        usersList.add(UserInfo(email, password))
    }


}