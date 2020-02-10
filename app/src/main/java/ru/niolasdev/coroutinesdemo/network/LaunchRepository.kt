package ru.niolasdev.coroutinesdemo.network

import java.lang.Exception

class LaunchRepository {
    private val client = RetrofitService.createService(
        SpaceXApi::class.java
    )

    suspend fun getPastLaunches() = try {
        client.getPastLaunches().map {
            it.convert()
        }
    } catch (e: Exception) {
        null
    }
}