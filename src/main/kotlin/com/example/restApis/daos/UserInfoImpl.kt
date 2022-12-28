package com.example.restApis.daos

import com.example.restApis.models.UserInfo
import com.example.restApis.models.UserInfos
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class UserInfoImpl : UserInfoFacade {

    private fun convertEntityToUserInfo(row: ResultRow) = UserInfo(
        email=row[UserInfos.email],
        password=row[UserInfos.password]
    )
    override suspend fun getAllUsers(): List<UserInfo> {
        return DatabaseFactory.dbQuery {
            UserInfos.selectAll().map(::convertEntityToUserInfo)
        }
    }

    override suspend fun getUserByEmailId(emailId: String): UserInfo? {
        return DatabaseFactory.dbQuery {
            UserInfos.select {
                UserInfos.email eq emailId
            }.map(::convertEntityToUserInfo).singleOrNull()
        }
    }

    override suspend fun addUser(userInfo: UserInfo): String {
        return transaction {
            val insertStatement = UserInfos.insert {
                it[email] = userInfo.email
                it[password] = userInfo.password
            }
            insertStatement.resultedValues?.get(0)?.get(UserInfos.email)?:""
        }
    }

    override suspend fun deleteUser(emailId: String): Int {
        return transaction {
            UserInfos.deleteWhere {
                (email.eq(emailId))
            }
        }

    }

    override suspend fun editUser(emailId: String): Boolean {
        TODO("Not yet implemented")
    }
}