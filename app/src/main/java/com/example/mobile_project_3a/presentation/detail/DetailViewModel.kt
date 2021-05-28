package com.example.mobile_project_3a.presentation.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile_project_3a.presentation.Global
import com.example.mobile_project_3a.presentation.Singleton
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class DetailViewModel : ViewModel() {
    val cryptoDetail : MutableLiveData<DetailModel> = MutableLiveData()

    private val numCrypto = Global.numCryptoAsked

    private val urlDetail =
        "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?CMC_PRO_API_KEY=794ea8e7-4d80-4942-8171-4ca3b65d445c&id=$numCrypto"
    init {
        runDetailAPI(urlDetail, numCrypto)
    }

    private fun runDetailAPI(url: String, numCrypto: String){

        cryptoDetail.value = DetailLoader

        val request = Request.Builder()
            .url(url)
            .build()

        Singleton.clientDetail.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("fail", "onFailure -> runDetailAPI()")
                cryptoDetail.value = DetailError
            }
            override fun onResponse(call: Call, response: Response) {
                val jsonReply = response.body?.string()
                val finalText = jsonReply?.let { it -> printDetail( it, numCrypto ) }
                val logo = jsonReply?.let { it -> getLogo(it, numCrypto) }
                cryptoDetail.postValue(DetailSuccess(finalText, logo))
            }
        })
    }

    fun printDetail (jsonString: String, numCrypto: String): String {

        val jsonData = JSONObject(jsonString) // String instance holding the above json
        val jsonID = jsonData.getJSONObject("data")
        val jsonDetail = jsonID.getJSONObject(numCrypto)
        //val toDisplay = "Here is a quick description of: \n - " + jsonDetail.getString("name") + "\n\n" + jsonDetail.getString("description")
        //textView.text = toDisplay
        return "Here is a quick description of: \n - " + jsonDetail.getString("name") + "\n\n" + jsonDetail.getString("description")
    }

    fun getLogo (jsonString: String, numCrypto: String): String {

        val jsonData = JSONObject(jsonString) // String instance holding the above json
        val jsonID = jsonData.getJSONObject("data")
        val jsonDetail = jsonID.getJSONObject(numCrypto)
        //val toDisplay = "Here is a quick description of: \n - " + jsonDetail.getString("name") + "\n\n" + jsonDetail.getString("description")
        //textView.text = toDisplay
        return jsonDetail.getString("logo")
    }
}