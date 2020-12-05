package com.kotlin.illusiontoreality.currencyconverter.api

import com.kotlin.illusiontoreality.currencyconverter.pojo.ConvertResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConvertApi {

    // online api to get latest currencies, access key is static
    @GET("live?access_key=6e162e19e515773da2495d5af537c32e")
    fun getLiveCurrency(): Call<ConvertResponse>

}