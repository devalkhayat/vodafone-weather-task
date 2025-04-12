package com.vodafone.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vodafone.data.datasource.local.daos.CityWeatherDao
import com.vodafone.data.datasource.local.daos.WeatherRecordsDao
import com.vodafone.data.datasource.local.entities.CityWeatherInfo
import com.vodafone.data.datasource.local.entities.WeatherRecords

@Database(entities = [CityWeatherInfo::class,WeatherRecords::class] , version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cityWeatherInfoDao(): CityWeatherDao
    abstract fun weatherRecordsDao(): WeatherRecordsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}