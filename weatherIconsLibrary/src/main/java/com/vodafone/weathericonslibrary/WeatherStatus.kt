package com.vodafone.weathericonslibrary

import androidx.annotation.RawRes
import java.util.Locale

sealed class WeatherStatus(){
    data class Clear(@RawRes val resId: Int=R.raw.ic_clear):WeatherStatus()
    data class Drizzle(@RawRes val resId: Int=R.raw.ic_drizzle):WeatherStatus()
    data class Rain(@RawRes val resId: Int=R.raw.ic_rain):WeatherStatus()
    data class Snow(@RawRes val resId: Int=R.raw.ic_snow):WeatherStatus()
    data class Thunderstorm(@RawRes val resId: Int=R.raw.ic_thunderstorm):WeatherStatus()
    data class Clouds(@RawRes val resId: Int=R.raw.ic_clouds):WeatherStatus()
    data class Other(@RawRes val resId: Int=R.raw.ic_unknown):WeatherStatus()
}

fun GetIcon(status:String)=
                            when(status.lowercase(Locale.getDefault())){
                                "clear"->WeatherStatus.Clear().resId
                                "drizzle"->WeatherStatus.Drizzle().resId
                                "rain"->WeatherStatus.Rain().resId
                                "snow"->WeatherStatus.Snow().resId
                                "thunderstorm"->WeatherStatus.Thunderstorm().resId
                                "clouds"->WeatherStatus.Clouds().resId
                                else -> WeatherStatus.Other().resId

                            }



