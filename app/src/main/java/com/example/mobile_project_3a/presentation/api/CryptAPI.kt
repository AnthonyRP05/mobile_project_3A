package com.example.mobile_project_3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptAPI {
        @GET("map")
        fun getCryptoList(@Query("CMC_PRO_API_KEY") MC_PRO_API_KEY: String): Call<CryptoResponse>
}