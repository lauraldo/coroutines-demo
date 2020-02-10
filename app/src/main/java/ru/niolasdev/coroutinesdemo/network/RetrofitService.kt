package ru.niolasdev.coroutinesdemo.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.niolasdev.coroutinesdemo.BuildConfig

object RetrofitService {

    private const val BASE_URL = "https://api.spacexdata.com/"

    private val loggingInterceptor = run {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    private val client = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(loggingInterceptor)
        }
    }.build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

}