package com.example.restApis.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class UserInfo(val email: String, val password: String) {
}

object UserInfos: Table() {
    private val id = integer("id").autoIncrement()
    val email = varchar("email", 200)
    val password = varchar("password", 200)

    override val primaryKey = PrimaryKey(id)
}