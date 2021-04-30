package com.zaidzakir.currencyconverter.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Zaid Zakir
 */


interface Api {

    @GET("api.exchangeratesapi.io/v1/latest?access_key=ab88d34f71b422892198d25b26ce8de4")
    suspend fun getCurrencyRates(@Query("base") base:String) : Response<CurrencyResponse>
}