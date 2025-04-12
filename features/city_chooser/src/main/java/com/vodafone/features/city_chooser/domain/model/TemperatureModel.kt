package com.vodafone.features.city_chooser.domain.model

data class TemperatureModel(val day:String,val maxDegree:String,val minDegree:String, val humidity:String, val windSpeed:String,val status:WeatherStatusModel)