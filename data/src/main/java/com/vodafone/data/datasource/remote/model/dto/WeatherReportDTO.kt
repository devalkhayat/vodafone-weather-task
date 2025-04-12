package com.vodafone.data.datasource.remote.model.dto


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class WeatherReportDTO(
    @SerializedName("clouds")
    val clouds: CloudsDTO,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("dt_txt")
    val dtTxt:String,
    @SerializedName("main")
    val main: MainDTO,
    @SerializedName("pop")
    val pop: Double,
    @SerializedName("rain")
    val rain: RainDTO,
    @SerializedName("sys")
    val sys: SysDTO,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weather: List<WeatherDTO>,
    @SerializedName("wind")
    val wind: WindDTO
)