package com.example

import com.example.koin.confs.appModule
import com.example.koin.confs.modelModules
import com.example.plugins.configureRouting
import com.example.plugins.configureUserRouting
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    // Needed for serialization
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowMethod(HttpMethod.Post)
        allowHeader("MyCustomHeader")
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    // Needed For Koin DI
    startKoin {
        modules(appModule, modelModules)
    }

    //Configure Routing
    configureRouting()
    configureUserRouting()
}
