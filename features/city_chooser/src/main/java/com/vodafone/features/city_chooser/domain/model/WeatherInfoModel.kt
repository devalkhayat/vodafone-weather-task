package com.vodafone.features.city_chooser.domain.model

data class WeatherInfoModel(val city:String , val day:String , val dateTime:String ,val temperatureCurrent :TemperatureModel , val temperatureRecords: List<TemperatureModel> , val status: WeatherStatusModel)





