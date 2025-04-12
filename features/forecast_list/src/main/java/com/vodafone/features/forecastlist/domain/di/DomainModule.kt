package com.vodafone.features.forecastlist.domain.di


import com.vodafone.features.forecastlist.domain.repo.ForeCastListRepository
import com.vodafone.features.forecastlist.domain.use_cases.GetLocalFutureInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetLocalFutureInfoUseCase(foreCastListRepository: ForeCastListRepository): GetLocalFutureInfoUseCase {
        return GetLocalFutureInfoUseCase(foreCastListRepository)
    }

}