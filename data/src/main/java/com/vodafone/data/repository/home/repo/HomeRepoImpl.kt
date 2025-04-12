package com.vodafone.data.repository.home.repo

import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.repository.home.mappers.toDomainInstance
import com.vodafone.features.home.domain.model.CityWeatherInfoModel
import com.vodafone.features.home.domain.repo.HomeRepository
import javax.inject.Inject

 class HomeRepoImpl @Inject constructor(private val db: AppDatabase): HomeRepository {

     override suspend fun getStoredInformation(): CityWeatherInfoModel {

         return db.cityWeatherInfoDao().Get().toDomainInstance()
     }
 }