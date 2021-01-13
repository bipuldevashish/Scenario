package com.bipuldevashish.pro_x.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bipuldevashish.pro_x.R
import com.bipuldevashish.pro_x.ui.main.MainActivity
import com.bipuldevashish.pro_x.ui.main.MainViewModel
import com.bipuldevashish.pro_x.utils.Resource
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var homeImageAdapter: HomeImageAdapter

    private val TAG = "HomeFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel = (activity as MainActivity).viewModel
        homeImageAdapter = HomeImageAdapter()

        view.recyclerView_images.apply {
            adapter = homeImageAdapter
            layoutManager = GridLayoutManager(context,3)
        }

        viewModel.imageList.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { imageResponse ->
                        homeImageAdapter.setData(imageResponse.photos)
                        Log.d(TAG, "onCreateView: ${imageResponse.photos?.size}")
                    }
                }
                is Resource.Error -> {
                    Log.d(TAG, "onCreateView: ${response.message}")
                }
                is Resource.Loading -> {
                    // for handling the loading state
                }
            }
        })

        return view
    }

}