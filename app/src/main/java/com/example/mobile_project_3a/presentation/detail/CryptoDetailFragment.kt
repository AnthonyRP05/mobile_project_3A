package com.example.mobile_project_3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.databinding.FragmentCryptoDetailBinding
import com.example.mobile_project_3a.presentation.Singleton
import com.example.mobile_project_3a.presentation.api.CryptoDetailResponse
import com.example.mobile_project_3a.presentation.list.Coin
import com.example.mobile_project_3a.presentation.list.CryptoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CryptoDetailFragment : Fragment() {

    private var _binding: FragmentCryptoDetailBinding? = null
    private val adapter = CryptoAdapter(listOf(), ::onClikedCoin)

    private lateinit var textViewName: TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCryptoDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.navToCryptoListFragment)
        }
        textViewName = view.findViewById(R.id.crypto_detail_name)
        callAPI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun callAPI() {

        val apiKey = "794ea8e7-4d80-4942-8171-4ca3b65d445c"
        val idCrypto = "2"

        Singleton.cryptAPI.getCryptoDetail(apiKey, idCrypto).enqueue(object : Callback<CryptoDetailResponse> {
                override fun onResponse(call: Call<CryptoDetailResponse>, response: Response<CryptoDetailResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        println("SUCCESS")
                  //      textViewName.text = response.body().data
                    }
                }

                override fun onFailure(call: Call<CryptoDetailResponse>, t: Throwable) {
                }
            })


    }

    private fun onClikedCoin(coin: Coin) {
        findNavController().navigate(R.id.navToCryptoListFragment)
    }
}

