package com.demo.model


data class TempData(
    val currently: Currently,
   // val daily: Daily,
   /* val flags: Flags,
    val hourly: Hourly,
    val latitude: Double,
    val longitude: Double,
    val minutely: Minutely,
    val offset: Int*/
    val timezone: String
)

data class Currently(
    val apparentTemperature: Double,
    val cloudCover: Double,
    val dewPoint: Double,
    val humidity: Double,
    val icon: String,
    val nearestStormBearing: Int,
    val nearestStormDistance: Int,
    val ozone: Double,
    val precipIntensity: Double,
    val precipProbability: Double,
    val pressure: Double,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val uvIndex: Int,
    val visibility: Double,
    val windBearing: Int,
    val windGust: Double,
    val windSpeed: Double
)

data class Daily(
    val `data`: List<Data>,
    val icon: String,
    val summary: String
)

data class Flags(
    val nearest_station: Double,
    val sources: List<String>,
    val units: String
)

data class Hourly(
    val `data`: List<DataX>,
    val icon: String,
    val summary: String
)

data class Minutely(
    val `data`: List<DataXX>,
    val icon: String,
    val summary: String
)

data class Data(
    val apparentTemperatureHigh: Double,
    val apparentTemperatureHighTime: Int,
    val apparentTemperatureLow: Double,
    val apparentTemperatureLowTime: Int,
    val apparentTemperatureMax: Double,
    val apparentTemperatureMaxTime: Int,
    val apparentTemperatureMin: Double,
    val apparentTemperatureMinTime: Int,
    val cloudCover: Double,
    val dewPoint: Double,
    val humidity: Double,
    val icon: String,
    val moonPhase: Double,
    val ozone: Double,
    val precipIntensity: Double,
    val precipIntensityMax: Double,
    val precipIntensityMaxTime: Int,
    val precipProbability: Double,
    val precipType: String,
    val pressure: Double,
    val summary: String,
    val sunriseTime: Int,
    val sunsetTime: Int,
    val temperatureHigh: Double,
    val temperatureHighTime: Int,
    val temperatureLow: Double,
    val temperatureLowTime: Int,
    val temperatureMax: Double,
    val temperatureMaxTime: Int,
    val temperatureMin: Double,
    val temperatureMinTime: Int,
    val time: Int,
    val uvIndex: Int,
    val uvIndexTime: Int,
    val visibility: Int,
    val windBearing: Int,
    val windGust: Double,
    val windGustTime: Int,
    val windSpeed: Double
)

data class DataX(
    val apparentTemperature: Double,
    val cloudCover: Double,
    val dewPoint: Double,
    val humidity: Double,
    val icon: String,
    val ozone: Double,
    val precipIntensity: Int,
    val precipProbability: Int,
    val precipType: String,
    val pressure: Double,
    val summary: String,
    val temperature: Double,
    val time: Int,
    val uvIndex: Int,
    val visibility: Int,
    val windBearing: Int,
    val windGust: Double,
    val windSpeed: Double
)

data class DataXX(
    val precipIntensity: Int,
    val precipProbability: Int,
    val time: Int
)