package com.bipuldevashish.pro_x.ui.search

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), SearchImageAdapter.OnitemClickListner {

    private val viewModel by viewModels<SearchViewModel>()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSearchBinding.bind(view)

        val searchAdapter = SearchImageAdapter(this)

        binding.editTextSearch.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    getStringFromEditText()
                    true
                }
                else -> false
            }
        }

        binding.recyclerViewSearchFragment.apply {
            setHasFixedSize(true)
            adapter = searchAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        viewModel.photos.observe(viewLifecycleOwner) {
            searchAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    fun getStringFromEditText() {
        binding.editTextSearch.text.trim().let {
            if (it.isNotEmpty()) {
                binding.recyclerViewSearchFragment.scrollToPosition(0)
                viewModel.searchPhotos(it.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(photo: ImageList.Photos) {
            val action = SearchFragmentDirections.actionSearchToSingleImageFragment3(photo)
            findNavController().navigate(action)
    }
}