package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Application.configureRouting() {

    routing {
        get("/") {
            println("Request Headers are ${call.request.headers.names()}")
            println("Query Parameters are ${call.request.queryParameters.names()}")
            println("Path Parameters are ${call.request.path()}")
            call.respondText("Hello World!")
        }

        get("/user/{userId}") {
            println("Path Parameters are ${call.parameters.names()}")
            println("Value of Path parameter userId is: ${call.parameters["userId"]}")
            call.respondText("User Name is Alex")
        }
    }
}
