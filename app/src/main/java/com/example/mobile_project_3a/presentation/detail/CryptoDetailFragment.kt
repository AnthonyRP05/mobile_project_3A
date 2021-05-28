package com.example.mobile_project_3a.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.databinding.FragmentSecondBinding
import com.example.mobile_project_3a.presentation.Global
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CryptoDetailFragment : Fragment() {
    //lateinit var numCryptoAsked : String

    private val args: CryptoDetailFragmentArgs by navArgs()
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private var _binding: FragmentSecondBinding? = null

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var load : ProgressBar
    private lateinit var imageViewError: ImageView

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
        Global.numCryptoAsked = args.numCrypto
        textView = view.findViewById(R.id.crypto_detail_name)
        imageView = view.findViewById(R.id.crypto_logo)

        load = view.findViewById(R.id.crypto_loaderDetail)
        imageViewError = view.findViewById(R.id.crypto_errorDetail)

        viewModel.cryptoDetail.observe(viewLifecycleOwner, {
            load.isVisible = it is DetailLoader
            imageViewError.isVisible = it is DetailError
            if(it is DetailSuccess){
                textView.text = it.detailList.toString()
                val logoToDisplay = it.logo.toString()
                Picasso.get().load(logoToDisplay).into(imageView)
            }
        })

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
