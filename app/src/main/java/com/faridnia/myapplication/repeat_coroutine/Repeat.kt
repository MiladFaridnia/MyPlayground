package com.faridnia.myapplication.repeat_coroutine

import kotlinx.coroutines.delay
import java.io.IOException

suspend fun callWithRetry(): String {
    repeat(3) { attempt ->
        delay(3000)
        try {
            val result = fetchData()
            println("Success at attempt #$attempt")
            return result
        } catch (e: IOException) {
            println("Attempt #$attempt failed: ${e.message}")
            delay(1000L) // optional delay between retries
        }
    }
    throw IOException("")
}

private suspend fun fetchData(): String {
    // Simulate network call
    delay(700)
    if (Math.random() < 0.7) {
        throw IOException("Fake network error")
    }
    return "Success from API!"
}