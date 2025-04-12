package com.vodafone.data.repository.home.mappers

import com.vodafone.data.datasource.local.entities.CityWeatherInfo
import com.vodafone.features.home.domain.model.CityWeatherInfoModel


fun CityWeatherInfo.toDomainInstance(): CityWeatherInfoModel {
    return CityWeatherInfoModel(cityName = this.cityName, cityDegree = this.degree, cityStatus = this.status)
}
