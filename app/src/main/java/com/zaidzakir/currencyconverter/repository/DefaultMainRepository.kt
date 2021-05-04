package com.zaidzakir.currencyconverter.repository

import com.zaidzakir.currencyconverter.model.Api
import com.zaidzakir.currencyconverter.model.CurrencyResponse
import com.zaidzakir.currencyconverter.util.Resource
import java.lang.Exception
import javax.inject.Inject

/**
 *Created by Zaid Zakir
 */

class DefaultMainRepository @Inject constructor(
    private val api:Api
) :MainRepository{

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getCurrencyRates(base)
            val result = response.body()
            if (response.isSuccessful && result!=null){
                Resource.Success(result)
            }else{
                Resource.Error(response.message())
            }
        }catch (e:Exception){
            Resource.Error(e.message?:"An error occured")
        }
    }
}