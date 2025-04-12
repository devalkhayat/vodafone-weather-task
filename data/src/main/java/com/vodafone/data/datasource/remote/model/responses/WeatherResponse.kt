package com.vodafone.data.datasource.remote.model.responses

import com.vodafone.data.datasource.remote.model.dto.CityDTO
import com.google.gson.annotations.SerializedName
import com.vodafone.data.datasource.remote.model.dto.WeatherReportDTO


data class WeatherResponse(
    @SerializedName("city")
    val city: CityDTO ,
    @SerializedName("cnt")
    val cnt: Int ,
    @SerializedName("cod")
    val cod: String ,
    @SerializedName("list")
    val list: List<WeatherReportDTO> ,
    @SerializedName("message")
    val message: Int
)