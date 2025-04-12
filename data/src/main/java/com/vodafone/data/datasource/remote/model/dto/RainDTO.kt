package com.vodafone.data.datasource.remote.model.dto


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class RainDTO(
    @SerializedName("3h")
    val h: Double
)