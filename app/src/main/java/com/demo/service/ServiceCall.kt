package com.demo.service

import com.demo.model.TempData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface ServiceCall {

    @GET("forecast/900435862f097f4cc7a2021dd67b8c12/{lat_lng}, {lat_lng1}")
    fun getTempList(@Path("lat_lng")position : String , @Path("lat_lng1")position1: String) : Observable<TempData>
}