package com.bipuldevashish.pro_x.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bipuldevashish.pro_x.data.repository.ImageRepository
import com.bipuldevashish.pro_x.data.repository.PexelRepository

class SearchViewModel @ViewModelInject constructor(
    private val repository: PexelRepository
): ViewModel(){


    companion object{
        private const val DEFAULT_QUERY = "cars"
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchReasults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query : String) {
        currentQuery.value = query
    }
}