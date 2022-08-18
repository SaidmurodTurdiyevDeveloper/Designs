package com.designs.mybeautifuldesigns.designs.fragments.design_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import designs.mybeautifuldesigns.R
import designs.mybeautifuldesigns.databinding.DesignFirstScreenHomeBinding

/**
 * Created by Saidmurod Turdiyev (S.M.T) on 15/08/2022.
 */
@AndroidEntryPoint
class DesignFirstHomeFragment : Fragment(R.layout.design_first_screen_home) {
    private var _binding: DesignFirstScreenHomeBinding? = null
    private val binding: DesignFirstScreenHomeBinding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DesignFirstScreenHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}