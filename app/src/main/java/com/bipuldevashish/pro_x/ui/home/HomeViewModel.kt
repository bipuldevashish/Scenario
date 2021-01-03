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
    var perPageImageCount = 20
    private val TAG = "MainViewModel"

    init {
        getImageResults(
                apiKey = "563492ad6f917000010000018bc38c66a1bc4522bbe044d69a19e744"
        )
    }

    fun getImageResults(apiKey: String) = viewModelScope.launch {
        imagelist.postValue(Resource.Loading())
        val response = imageRepository.getImagesResults(api_key = apiKey, page = imagePage,per_page = perPageImageCount )
        imagelist.postValue(handlerImageResponse(response))
        Log.d(TAG, "getImageResults: imagelistsize : ${response.body()?.photos?.size}")
    }

    private fun handlerImageResponse(response: Response<ImageList>) : Resource<ImageList> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
//                This log is jus to check wether we're getting the correct data or not
                Log.d(TAG, "getImageResults: ${resultResponse.photos.get(0).url}")
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}
