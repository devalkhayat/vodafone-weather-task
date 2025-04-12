package com.vodafone.data.repository.city_chooser.di

import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.datasource.remote.dataproviders.WeatherDataProviders
import com.vodafone.data.repository.city_chooser.repo.CityChooserRepoImpl
import com.vodafone.features.city_chooser.domain.repo.CityChooserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideWeatherRepo(weatherDataProviders: WeatherDataProviders,db:AppDatabase): CityChooserRepository {
        return   CityChooserRepoImpl(weatherDataProviders , db)
    }

}