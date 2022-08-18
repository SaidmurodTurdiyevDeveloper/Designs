package com.designs.mybeautifuldesigns.designs.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.designs.mybeautifuldesigns.designs.adapter.FragmentAdapter
import com.designs.mybeautifuldesigns.designs.model.FragmentItem
import dagger.hilt.android.AndroidEntryPoint
import designs.mybeautifuldesigns.R
import designs.mybeautifuldesigns.databinding.ScreenHomeBinding
import javax.inject.Inject

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 15/08/2022.
 */
@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {

    private val binding: ScreenHomeBinding by viewBinding()
    lateinit var list: ArrayList<FragmentItem>

    @Inject
    lateinit var adapter: FragmentAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list = ArrayList()
        addList()
        loadUI()
    }

    private fun loadUI() {
        adapter.differList.submitList(list)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addList() {
        list.add(FragmentItem("Discover Online Shop", resources.getColor(R.color.color_first_design), resources.getColor(R.color.white)) {
            findNavController().navigate(R.id.action_homeScreen_to_designFirstHomeFragment)
        })
    }

}