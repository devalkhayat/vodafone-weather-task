package com.vodafone.features.forecastlist.domain.repo

import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel

interface ForeCastListRepository {
    suspend fun getStoredInformation(): List<LocalFutureWeatherModel>
}