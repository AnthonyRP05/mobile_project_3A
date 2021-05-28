package com.example.mobile_project_3a.presentation.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_project_3a.presentation.Singleton
import com.example.mobile_project_3a.presentation.api.CryptoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoViewModel : ViewModel() {

    val cryptoList : MutableLiveData<CryptoModel> = MutableLiveData()

    init {
        runAPI()
    }

    private fun runAPI() {

        cryptoList.value = CryptoLoader

        Singleton.cryptAPI.getCryptoList("794ea8e7-4d80-4942-8171-4ca3b65d445c").enqueue(object :
            Callback<CryptoResponse> {
            override fun onResponse(
                call: Call<CryptoResponse>,
                response: Response<CryptoResponse>
            ) {
                if (response.isSuccessful) {
                    val cryptoResponse = response.body()!!
                    cryptoList.value = CryptoSuccess(cryptoResponse.data.sortedBy { it.rank })
                }
                else
                    cryptoList.value = CryptoError
            }
            override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                Log.e("fail", "onFailure -> runAPI()")
                cryptoList.value = CryptoError
            }
        })
    }
}