package com.example.mobile_project_3a.presentation

import com.example.mobile_project_3a.presentation.api.CryptAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singleton {
    companion object {
        val cryptAPI: CryptAPI = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptAPI::class.java)
    }
}