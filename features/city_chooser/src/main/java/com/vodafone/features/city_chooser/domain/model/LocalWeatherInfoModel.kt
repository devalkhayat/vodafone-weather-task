package com.vodafone.features.city_chooser.domain.model

data class LocalWeatherInfoModel(
    val cityInfoModel:CityInfoModel ,
    val recordList:List<RecordModel>?=null
)
data class CityInfoModel(
    val cityName:String,
    val cityDegree:String,
    val cityStatus:String,
)
data class RecordModel(
    val day:String,
    val status:String,
    val degree:String
)