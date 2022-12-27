package com.example.coroutines

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val report = getWeatherReport1("1")
        println("Report is $report")
    }
}

suspend fun getWeatherReport1(block: String) =
    coroutineScope {
        val forecast: Deferred<String> = async {getForecast1(block)}
        val temperature: Deferred<String> = async{getTemperature1(block)}
        forecast.await() + temperature.await()
    }


suspend fun getTemperature1(block: String): String {
    println("Get Temp Call for Block $block")
    delay(5000)
    println("Temperature is 40 degree Celsius $block")
    return "40 degree Celsius $block"
}

suspend fun getForecast1(block: String): String {
    println("Get Forecast Call for Block $block")
    delay(3000)
    println("Sunny $block")
    return "Sunny $block"
}