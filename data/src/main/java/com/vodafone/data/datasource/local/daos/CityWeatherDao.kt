package com.vodafone.data.datasource.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vodafone.data.datasource.local.entities.CityWeatherInfo

@Dao
interface CityWeatherDao {

    @Insert()
    suspend fun Add(city:CityWeatherInfo):Unit

    @Query("SELECT * FROM tblCityWeatherInfo LIMIT 1")
    suspend fun Get():CityWeatherInfo

    @Query("DELETE FROM tblCityWeatherInfo")
    suspend fun Remove()
}