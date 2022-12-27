package com.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    println("Before coroutine call")
    runBlocking {
        println("Inside coroutine call")
        forecastWeather()
        forecastTemperature()
    }
}

suspend fun forecastWeather() {
    println("Forecasting weather: ")
    delay(3000)
    println("Sunny")
}

suspend fun forecastTemperature() {
    println("Forecasting Temperature for tomorrow")
    delay(2000)
    println("40 \u00b0C")
}