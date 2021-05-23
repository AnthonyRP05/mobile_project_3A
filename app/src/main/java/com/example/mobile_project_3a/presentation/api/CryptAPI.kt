package com.example.mobile_project_3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptAPI{
        @GET("map")
        fun getCryptoList(@Query("CMC_PRO_API_KEY") vs_currency:String): Call<CryptoListResponse>

        @GET("info")
        fun getCryptoDetail(@Query("CMC_PRO_API_KEY") vs_currency:String, @Query("id") id: String): Call<CryptoDetailResponse>
}
