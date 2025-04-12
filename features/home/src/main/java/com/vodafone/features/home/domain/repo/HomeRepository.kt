package com.vodafone.features.home.domain.repo

import com.vodafone.features.home.domain.model.CityWeatherInfoModel

interface HomeRepository {
    suspend fun getStoredInformation(): CityWeatherInfoModel
}