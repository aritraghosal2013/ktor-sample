package com.example.plugins

import com.example.restApis.models.UserInfo
import com.example.restApis.services.UserService
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.koin.ktor.ext.inject



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

                // Adding custom header
                call.response.headers.append("custom-header", "Aritra-Header")
                call.respondText("Headers Attached. User Name is Alex")
            }

            post("/user") {
                val userInfo = call.receive<UserInfo>()
                print("User Info is: $userInfo")
                call.respondText("User created successfully")
            }
        }
    }

    fun Application.configureUserRouting() {

        val userService by inject<UserService>()

        routing {

            get("/userInfo/{userId}") {
                val userId: String = call.parameters["userId"]?: "No-Email"
                println("Inside fetch userInfo api call")
                if(userId == "No-Email") {
                    call.respondText("No Username Provided")
                }
                val userInfo = userService.fetchUserByEmail(userId)
                call.respond(userService.fetchUserByEmail(userId)?:"User Not Found")
            }

            get("/listUserInfo") {
                call.respond(userService.fetchAllUsers())
            }

            post("/addUser") {
                val payload = call.receive<UserInfo>()
                println("Payload is $payload")
                userService.addUser(payload.email, payload.password)
                call.respond(mapOf("status" to "true", "message" to "User created successfully"))
            }

            delete("/userInfo/{userId}") {
                val userId: String = call.parameters["userId"]?: ""
                if(userId != "") {
                    if(userService.deleteUser(userId)>0){
                        call.respond(mapOf("status" to "true", "message" to "User Deleted Successfully"))
                    } else{
                        call.respond(mapOf("status" to "false", "message" to "User Could not be deleted"))
                    }

                }
                call.respond(mapOf("status" to "false", "message" to "User Not Found"))
            }
        }
    }



