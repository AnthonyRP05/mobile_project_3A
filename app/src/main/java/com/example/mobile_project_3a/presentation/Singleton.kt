package com.example.mobile_project_3a.presentation

import com.example.mobile_project_3a.presentation.api.CryptAPI
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singleton {
    companion object {
//        var myCache = Cache(File(MyApplication.appContext?.cacheDir, "responses"), 10*4096*4096)

/*        private var OkttpClientCache = OkHttpClient().newBuilder()
            .cache(myCache)
            .build()
*/
        val clientDetail = OkHttpClient().newBuilder()
            .build()

        val cryptAPI: CryptAPI = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptAPI::class.java)

        val cryptoListAPI = OkHttpClient().newBuilder()
            .build()

    }

}
