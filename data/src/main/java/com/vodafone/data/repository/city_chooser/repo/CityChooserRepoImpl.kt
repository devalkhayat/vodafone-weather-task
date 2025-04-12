package com.vodafone.data.repository.city_chooser.repo


import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.datasource.remote.dataproviders.WeatherDataProviders
import com.vodafone.data.repository.city_chooser.mappers.toDataSourceInstance
import com.vodafone.data.repository.city_chooser.mappers.toDomainInstance
import com.vodafone.features.city_chooser.domain.model.LocalWeatherInfoModel
import com.vodafone.features.city_chooser.domain.model.WeatherInfoModel
import com.vodafone.features.city_chooser.domain.repo.CityChooserRepository
import javax.inject.Inject

class CityChooserRepoImpl @Inject constructor(private val weatherDataProviders: WeatherDataProviders , private val db: AppDatabase) :
    CityChooserRepository {
    override suspend fun getCurrentWeatherInformation(
        latitude: String,
        longitude: String,
        unit:String
    ): WeatherInfoModel =  weatherDataProviders.getCurrentWeatherInformation(lat = latitude , lon = longitude , unit=unit).toDomainInstance()

    override suspend fun addToLocal(localWeatherInfoModel: LocalWeatherInfoModel): Boolean {

        try {

            db.cityWeatherInfoDao().Remove()
            db.weatherRecordsDao().RemoveAll()
            //
            db.cityWeatherInfoDao().Add(localWeatherInfoModel.cityInfoModel.toDataSourceInstance())
            localWeatherInfoModel.recordList?.forEach {
                db.weatherRecordsDao().Add(it.toDataSourceInstance())
            }

            return true
        } catch(ex:Exception) {
            return false
        }
    }

}