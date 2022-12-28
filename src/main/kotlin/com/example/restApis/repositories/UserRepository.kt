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
    override fun fetchUser(email: String): Any {
        println("Fetching user with email id: $email")
        return try {
            usersList.first { it.email == email }
        } catch(ex: NoSuchElementException) {
            ""
        }
    }

    override fun fetchAllUsers(): List<UserInfo> {
        println("Fetching all users")
        return usersList
    }

    override fun addUser(email: String, password: String): Unit {
        usersList.add(UserInfo(email, password))
    }

    override fun deleteUser(email: String) {
        val index = usersList.map { userInfo -> userInfo.email  }.indexOf(email)
        if(index != -1)
            usersList.removeAt(index)
    }


}