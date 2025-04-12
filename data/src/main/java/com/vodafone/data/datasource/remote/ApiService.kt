package com.vodafone.data.datasource.remote

import com.vodafone.data.datasource.remote.model.responses.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/forecast")
    suspend fun getCurrentWeather(@Query("lat") lat:String , @Query("lon") lon:String , @Query("units") unit:String): WeatherResponse
}