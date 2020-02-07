package ru.niolasdev.coroutinesdemo.network

import retrofit2.http.GET
import ru.niolasdev.coroutinesdemo.network.response.LaunchMissionInfo

interface SpaceXApi {

    @GET("/v3/launches/past")
    suspend fun getPastLaunches(): List<LaunchMissionInfo>

}