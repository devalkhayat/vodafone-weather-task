package com.vodafone.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblCityWeatherInfo")
data class CityWeatherInfo(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val cityName:String,
    val status:String,
    val degree:String
)
