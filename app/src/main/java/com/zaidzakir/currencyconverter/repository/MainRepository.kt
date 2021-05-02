package com.zaidzakir.currencyconverter.repository

import com.zaidzakir.currencyconverter.util.Resource

/**
 *Created by Zaid Zakir
 */
//a similar version of our repository created to do testing
interface MainRepository {
    suspend fun getRates(base:String): Resource<CurrencyResponse>
}