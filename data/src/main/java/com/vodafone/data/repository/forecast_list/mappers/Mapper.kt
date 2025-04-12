package com.vodafone.data.repository.forecast_list.mappers

import com.vodafone.data.datasource.local.entities.WeatherRecords
import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel


fun WeatherRecords.toDomainInstance(): LocalFutureWeatherModel {
    return LocalFutureWeatherModel(day=this.day, status = this.status, degree = this.degree)
}