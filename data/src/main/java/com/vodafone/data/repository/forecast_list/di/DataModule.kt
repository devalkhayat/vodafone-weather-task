package com.vodafone.data.repository.forecast_list.di

import com.vodafone.data.datasource.local.AppDatabase
import com.vodafone.data.repository.forecast_list.repo.ForeCastListRepoImpl
import com.vodafone.features.forecastlist.domain.repo.ForeCastListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun  provideHomeRepo(db: AppDatabase): ForeCastListRepository {
        return ForeCastListRepoImpl(db)
    }
}