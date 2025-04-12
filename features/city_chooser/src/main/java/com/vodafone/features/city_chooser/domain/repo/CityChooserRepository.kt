package com.vodafone.features.city_chooser.domain.repo

import com.vodafone.features.city_chooser.domain.model.LocalWeatherInfoModel
import com.vodafone.features.city_chooser.domain.model.WeatherInfoModel

interface CityChooserRepository {
    suspend fun getCurrentWeatherInformation(latitude:String,longitude:String,unit:String): WeatherInfoModel
    suspend fun addToLocal(localWeatherInfoModel: LocalWeatherInfoModel):Boolean
}