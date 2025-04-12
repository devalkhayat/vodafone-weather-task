package com.vodafone.features.city_chooser.domain.di


import com.vodafone.features.city_chooser.domain.repo.CityChooserRepository
import com.vodafone.features.city_chooser.domain.use_cases.GetCurrentWeatherInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun provideGetCurrentWeatherInfoUseCase(cityChooserRepository: CityChooserRepository): GetCurrentWeatherInfoUseCase {
        return GetCurrentWeatherInfoUseCase(cityChooserRepository)
    }
}