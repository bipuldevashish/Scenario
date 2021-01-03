package com.bipuldevashish.pro_x.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bipuldevashish.pro_x.data.models.ImageList
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.bipuldevashish.pro_x.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel  (
    val imageRepository: ImageRepository
): ViewModel(){

    val imagelist: MutableLiveData<Resource<ImageList>> = MutableLiveData()
    var imagePage = 1
    var perPageImageCount = 80
    private val TAG = "MainViewModel"

    init {
        getImageResults(
                apiKey = "11962816-c075381f0fbbba991df10a0d8",
                query = "nature"
        )
    }

    fun getImageResults(apiKey: String, query : String) = viewModelScope.launch {
        imagelist.postValue(Resource.Loading())
        val response = imageRepository.getImagesResults(api_key = apiKey, query = query , page = imagePage,per_page = perPageImageCount )
        imagelist.postValue(handlerImageResponse(response))
        Log.d(TAG, "getImageResults: imagelistsize : ${response.body()?.photos?.size}")
    }

    private fun handlerImageResponse(response: Response<ImageList>) : Resource<ImageList> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
//                This log is jus to check wether we're getting the correct data or not
                Log.d(TAG, "getImageResults: ${resultResponse.photos.get(0).pageURL}")
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}
