package com.vodafone.data.datasource.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblWeatherRecords")
data class WeatherRecords(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val day:String,
    val status:String,
    val degree:String
)
