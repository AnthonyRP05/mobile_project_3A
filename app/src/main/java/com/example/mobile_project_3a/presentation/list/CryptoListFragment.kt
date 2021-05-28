package com.example.mobile_project_3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.databinding.FragmentFirstBinding
import com.example.mobile_project_3a.presentation.Singleton
import com.example.mobile_project_3a.presentation.api.CryptoResponse
import okhttp3.Request
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CryptoListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CryptoAdapter(listOf(), ::onClickedCoin)
    private val viewModel : CryptoViewModel by viewModels()

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

        recyclerView = view.findViewById(R.id.crypto_recyclerview)
        recyclerView.apply {
            layoutManager = this@CryptoListFragment.layoutManager
            adapter = this@CryptoListFragment.adapter
        }

        viewModel.cryptoList.observe(viewLifecycleOwner, Observer{
            adapter.updateList(it)
        })
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickedCoin(coin: Coin) {
        val navigate = CryptoListFragmentDirections.navToCryptoDetailFragment(coin.id.toString())
        findNavController().navigate(navigate)
    }
}