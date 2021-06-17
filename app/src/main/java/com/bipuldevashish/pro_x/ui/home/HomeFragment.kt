package com.bipuldevashish.pro_x.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.data.models.Photos
import com.bipuldevashish.pro_x.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home),HomeImageAdapter.OnitemClickListner {

    private var viewModel: HomeViewModel? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.show()


        _binding = FragmentHomeBinding.bind(view)

        val homeImageAdapter = HomeImageAdapter(this)


        binding.recyclerViewImages.apply {
            setHasFixedSize(true)
            adapter = homeImageAdapter
            layoutManager = GridLayoutManager(context, 3)
        }

        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        viewModel!!.photos.observe(viewLifecycleOwner) {
            homeImageAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(photo: Photos) {
        val action = HomeFragmentDirections.actionHomeToSingleImageFragment(photo)
        findNavController().navigate(action)
    }

}