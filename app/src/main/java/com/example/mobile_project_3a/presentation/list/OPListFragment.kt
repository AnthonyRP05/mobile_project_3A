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

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OPListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = OP_Adapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.op_recyclerview)
        recyclerView.apply {
            layoutManager = this@OPListFragment.layoutManager
            adapter = this@OPListFragment.adapter
        }

        val opList : ArrayList<Onepiece> = arrayListOf<Onepiece>().apply {
            add(Onepiece("Luffy"))
            add(Onepiece("Zorro"))
            add(Onepiece("Chopper"))
            add(Onepiece("Sanji"))
            add(Onepiece("Brook"))
            add(Onepiece("Nami"))
            add(Onepiece("Nico Robin"))
            add(Onepiece("Frrraaaanky"))
            add(Onepiece("Ace"))
        }

        adapter.updateList(opList)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}