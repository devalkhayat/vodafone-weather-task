package com.vodafone.data.repository.city_chooser.mappers

import com.vodafone.core.util.Constants
import com.vodafone.data.datasource.remote.model.responses.WeatherResponse
import com.vodafone.features.city_chooser.domain.model.TemperatureModel
import com.vodafone.features.city_chooser.domain.model.WeatherInfoModel
import com.vodafone.features.city_chooser.domain.model.WeatherStatusModel
import com.vodafone.core.util.toDayName
import com.vodafone.core.util.toDate
import com.vodafone.data.datasource.local.entities.CityWeatherInfo
import com.vodafone.data.datasource.local.entities.WeatherRecords
import com.vodafone.features.city_chooser.domain.model.CityInfoModel
import com.vodafone.features.city_chooser.domain.model.RecordModel

fun WeatherResponse.toDomainInstance(): WeatherInfoModel {

    val tempList= arrayListOf<TemperatureModel>()
    val dateList= arrayListOf<Long>()
    this.list.forEach { i->

      if(dateList.find { it.toDate() == i.dt.toDate()}==null){

          dateList.add(i.dt)

          val status= WeatherStatusModel(name= i.weather[0].main ,
                                         icon ="${Constants.BASE_IMAGE_URL}${i.weather[0].icon}.png" ,
                                         feelLikeDegree = i.main.feelsLike.toInt().toString())

          val temp= TemperatureModel(day = i.dt.toDayName(),
                                     maxDegree = i.main.tempMax.toInt().toString() ,
                                     minDegree = i.main.tempMin.toInt().toString() ,
                                     humidity = i.main.humidity.toInt().toString() ,
                                     windSpeed = i.wind.speed.toInt().toString(),
                                     status=status)
          tempList.add(temp)
      }



    }

    val current= this.list[0]


    val status= WeatherStatusModel(name= current.weather[0].main ,
                                   icon ="${Constants.BASE_IMAGE_URL}${current.weather[0].icon}.png" ,
                                   feelLikeDegree = current.main.feelsLike.toInt().toString())

    val weatherInfoModel=WeatherInfoModel(city=this.city.name,
                                          day = current.dt.toDayName(),
                                          dateTime =current.dt.toDate(),
                                          temperatureCurrent = tempList[0],
                                          temperatureRecords =tempList ,
                                          status =status )

    return  weatherInfoModel
}

fun CityInfoModel.toDataSourceInstance(): CityWeatherInfo {
    return CityWeatherInfo(cityName=this.cityName, status = this.cityStatus, degree = this.cityDegree)
}

fun RecordModel.toDataSourceInstance():WeatherRecords{
    return WeatherRecords(day=this.day,status=this.status,degree=this.degree)
}


