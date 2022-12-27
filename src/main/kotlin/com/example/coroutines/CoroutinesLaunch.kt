package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Gathering weather report")
        launch {
            println("Inside Launch block 1")
            getTemperature("1")
            delay(1000)
            getForecast("1")
        }
        launch {
            println("Inside launch block 2")
            getTemperature("2")
            getForecast("2")
        }
        println("After Launch Block execution completion")
    }
}

fun getWeatherReport() {

}

suspend fun getTemperature(block: String) {
    println("Get Temp Call for Block $block")
    delay(5000)
    println("Temperature is 40 degree Celsius $block")
}

suspend fun getForecast(block: String) {
    println("Get Forecast Call for Block $block")
    delay(3000)
    println("Sunny $block")
}