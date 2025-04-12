package com.vodafone.data.datasource.remote.model.dto


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsDTO(
    @SerializedName("all")
    val all: Int
)