package com.vodafone.data.repository.forecast_list.repo

import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.repository.forecast_list.mappers.toDomainInstance
import com.vodafone.features.forecastlist.domain.model.LocalFutureWeatherModel
import com.vodafone.features.forecastlist.domain.repo.ForeCastListRepository
import javax.inject.Inject

class ForeCastListRepoImpl @Inject constructor(private val db:AppDatabase): ForeCastListRepository {
    override suspend fun getStoredInformation(): List<LocalFutureWeatherModel> {

        val records= arrayListOf<LocalFutureWeatherModel>()

        db.weatherRecordsDao().Get().forEach {
            records.add(it.toDomainInstance())
        }

        return records
    }
}