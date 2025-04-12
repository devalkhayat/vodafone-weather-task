package com.vodafone.data.datasource.remote.model.dto
import com.google.gson.annotations.SerializedName


data class CityDTO(
    @SerializedName("coord")
    val coord: CoordDTO ,
    @SerializedName("country")
    val country: String ,
    @SerializedName("id")
    val id: Int ,
    @SerializedName("name")
    val name: String ,
    @SerializedName("population")
    val population: Int ,
    @SerializedName("sunrise")
    val sunrise: Int ,
    @SerializedName("sunset")
    val sunset: Int ,
    @SerializedName("timezone")
    val timezone: Int
)