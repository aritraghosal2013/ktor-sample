package com.example.restApis.daos

import com.example.restApis.models.UserInfo


interface UserInfoFacade {
    suspend fun getAllUsers(): List<UserInfo>
    suspend fun getUserByEmailId(emailId: String): UserInfo?
    suspend fun addUser(userInfo: UserInfo): String
    suspend fun deleteUser(emailId: String): Int
    suspend fun editUser(emailId: String): Boolean

}