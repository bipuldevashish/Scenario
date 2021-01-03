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
        private var perPageImageCount = 80
        private val TAG = "MAINVIEWMODEL"

        init {
                getImageResults(
                        apiKey = "11962816-c075381f0fbbba991df10a0d8",
                        query = "nature"

                )
        }

        private fun getImageResults(apiKey: String, query : String) = viewModelScope.launch {
                imageList.postValue(Resource.Loading())
                val response = imageRepository.getImagesResults(api_key = apiKey,query=query, page = imagepage, per_page = perPageImageCount)
                imageList.postValue(handleImageResponse(response))
                Log.d(TAG, "getImageResults: imagelist : ${response.body()?.photos?.size}")
        }

        private fun handleImageResponse(response: Response<ImageList>): Resource<ImageList> {
                if (response.isSuccessful){
                        response.body()?.let { resultResponse ->
                               //Log.d(TAG, "handleImageResponse: ${resultResponse.photos[0].largeURL}")
                                return Resource.Success(resultResponse)
                        }
                }
                return Resource.Error(response.message())
        }
}