package com.vodafone.data.datasource.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vodafone.data.datasource.local.entities.WeatherRecords

@Dao
interface WeatherRecordsDao {

    @Insert()
    suspend fun Add(record: WeatherRecords):Unit

    @Query("SELECT * FROM tblWeatherRecords")
    suspend fun Get(): List<WeatherRecords>

    @Query("DELETE FROM tblWeatherRecords")
    suspend fun RemoveAll()
}