package com.vodafone.data.datasource.remote.dataproviders

import com.vodafone.data.datasource.remote.ApiService
import javax.inject.Inject

class WeatherDataProviders @Inject constructor(private val apiService: ApiService) {
    suspend fun getCurrentWeatherInformation(lat:String,lon:String,unit:String)=apiService.getCurrentWeather(lat = lat, lon =lon,unit=unit )
}