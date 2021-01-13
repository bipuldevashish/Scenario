package com.bipuldevashish.pro_x.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home),HomeImageAdapter.OnitemClickListner {

    private var viewModel: HomeViewModel? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        val homeImageAdapter = HomeImageAdapter(this)


        binding.recyclerViewImages.apply {
            setHasFixedSize(true)
            adapter = homeImageAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        viewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel::class.java)
        viewModel!!.photos.observe(viewLifecycleOwner) {
            homeImageAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(photo: ImageList.Photos) {
        val action = HomeFragmentDirections.actionHomeToSingleImageFragment(photo)
        findNavController().navigate(action)
    }

}