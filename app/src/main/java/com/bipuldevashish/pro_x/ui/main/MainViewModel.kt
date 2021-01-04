package com.bipuldevashish.pro_x.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.bipuldevashish.pro_x.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (
        val imageRepository: ImageRepository
        ) : ViewModel(){

        val imageList : MutableLiveData<Resource<ImageList>> = MutableLiveData()
        private var imagepage = 1
        private var perPageImageCount = 78
        private val TAG = "MainViewModel"

        init {
                getImageResults()
        }

        private fun getImageResults() = viewModelScope.launch {
                imageList.postValue(Resource.Loading())
                val response = imageRepository.getImagesResults(page = imagepage, per_page = perPageImageCount)
                Log.d(TAG, "getImageResults: response : ${response.body()}")
                imageList.postValue(handleImageResponse(response))
                Log.d(TAG, "getImageResults: imagelist : ${response.body()?.photos?.size}")
        }

        private fun handleImageResponse(response: Response<ImageList>): Resource<ImageList> {
                if (response.isSuccessful){
                        response.body()?.let { resultResponse ->
                               Log.d(TAG, "handleImageResponse: ${resultResponse}")
                                return Resource.Success(resultResponse)
                        }
                }
                return Resource.Error(response.message())
        }
}