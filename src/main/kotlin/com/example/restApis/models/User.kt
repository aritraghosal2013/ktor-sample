package com.example.restApis.models

data class User(val uId: String, val name: String, val age: Int) {
    fun displayUserDetails() {
        println("User Details goes here")
        println(toString())
    }
}