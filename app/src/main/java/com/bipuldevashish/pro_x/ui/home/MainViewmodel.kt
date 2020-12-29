package com.bipuldevashish.pro_x.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.bipuldevashish.pro_x.utils.Resource

class MainViewmodel (
        val imageRepository: ImageRepository
        ) : ViewModel(){

        val imageList : MutableLiveData<Resource<ImageList>> = MutableLiveData()
}