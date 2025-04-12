package com.vodafone.features.home.domain.di

import com.vodafone.features.home.domain.repo.HomeRepository
import com.vodafone.features.home.domain.use_cases.GetLocalWeatherInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetLocalWeatherInfoUseCase(homeRepository: HomeRepository): GetLocalWeatherInfoUseCase {
        return GetLocalWeatherInfoUseCase(homeRepository)
    }

}