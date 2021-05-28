package com.example.mobile_project_3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.databinding.FragmentSecondBinding
import com.example.mobile_project_3a.presentation.Singleton
import com.squareup.picasso.Picasso
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CryptoDetailFragment : Fragment() {

    private val args: CryptoDetailFragmentArgs by navArgs()
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private var _binding: FragmentSecondBinding? = null
    private val client = OkHttpClient()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.navToCryptoListFragment)
        }
        val numCrypto = args.numCrypto
        textView = view.findViewById(R.id.crypto_detail_name)
        imageView = view.findViewById(R.id.crypto_logo)

        val urlDetail =
            "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?CMC_PRO_API_KEY=794ea8e7-4d80-4942-8171-4ca3b65d445c&id=$numCrypto"
      run(urlDetail, numCrypto)
    }

    private fun run(url: String, numCrypto: String){

        val request = Request.Builder()
            .url(url)
            .build()

       Singleton.clientDetail.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }
            override fun onResponse(call: Call, response: Response) {
                val jsonReply = response.body?.string()
                jsonReply?.let { it -> printDetail( it, numCrypto ) }
            }
        })
    }

    fun printDetail (jsonString: String, numCrypto: String){

        val jsonData = JSONObject(jsonString) // String instance holding the above json
        val jsonID = jsonData.getJSONObject("data")
        val jsonDetail = jsonID.getJSONObject(numCrypto)
        val toDisplay = "Here is a quick description of: \n - " + jsonDetail.getString("name") + "\n\n" + jsonDetail.getString("description")
        textView.text = toDisplay
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
