package com.example.restApis.models

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(val email: String, val password: String) {
}