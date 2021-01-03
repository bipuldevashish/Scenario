package com.bipuldevashish.pro_x.ui.main.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.bipuldevashish.pro_x.ui.main.MainViewModel

class MainViewModelFactory(private val imageRepository: ImageRepository) :
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(MainViewModel::class.java) ->
                        MainViewModel(imageRepository = imageRepository)
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T
}