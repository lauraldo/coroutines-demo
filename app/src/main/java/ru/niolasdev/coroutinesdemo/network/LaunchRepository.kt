package ru.niolasdev.coroutinesdemo.network

class LaunchRepository {

    var client = RetrofitService.createService(
        SpaceXApi::class.java
    )

    suspend fun getPastLaunches() = client.getPastLaunches().map {
        it.convert()
    }
}