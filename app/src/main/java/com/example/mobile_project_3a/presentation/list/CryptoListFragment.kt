package com.example.mobile_project_3a.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.databinding.FragmentFirstBinding
import com.example.mobile_project_3a.presentation.api.CryptAPI
import com.example.mobile_project_3a.presentation.api.CryptoResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CryptoListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CryptoAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.op_recyclerview)
        recyclerView.apply {
            layoutManager = this@CryptoListFragment.layoutManager
            adapter = this@CryptoListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cryptApi: CryptAPI = retrofit.create(CryptAPI::class.java)
        val apiKey = "794ea8e7-4d80-4942-8171-4ca3b65d445c"

        cryptApi.getCryptoList(apiKey).enqueue(object : Callback<CryptoResponse>{
            override fun onResponse(call: Call<CryptoResponse>, response: Response<CryptoResponse>) {
                if(response.isSuccessful ){
                    val cryptoResponse = response.body()!!
                    adapter.updateList(cryptoResponse.data)
                }
            }

            override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                println("t'es dans on faillure")
            }


        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
