package com.example.restApis.repositories

import com.example.restApis.daos.UserInfoFacade
import com.example.restApis.models.UserInfo

class UserRepository(private val userInfoImpl: UserInfoFacade): IUserRepository {
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
    override suspend fun fetchUser(email: String): Any? {
        return userInfoImpl.getUserByEmailId(email)
    }

    override suspend fun fetchAllUsers(): List<UserInfo> {
        println("Fetching all users")
        return userInfoImpl.getAllUsers()
    }

    override suspend fun addUser(email: String, password: String): Unit {
        userInfoImpl.addUser(UserInfo(email, password))
    }

    override suspend fun deleteUser(email: String): Int {
        return userInfoImpl.deleteUser(email)
    }
}