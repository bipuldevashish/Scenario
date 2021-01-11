package com.bipuldevashish.pro_x.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class Search : Fragment(R.layout.fragment_search) {

    private val viewModel by viewModels<SearchViewModel> ()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSearchBinding.bind(view)

        val searchAdapter = SearchImageAdapter()

        binding.recyclerViewSearchFragment.apply {
                setHasFixedSize(true)
                adapter= searchAdapter
                layoutManager = GridLayoutManager(context,3)
        }

        viewModel.photos.observe(viewLifecycleOwner){
            searchAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}