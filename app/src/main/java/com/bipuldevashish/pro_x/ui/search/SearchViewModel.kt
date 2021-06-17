package com.bipuldevashish.pro_x.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bipuldevashish.pro_x.data.repository.PexelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: PexelRepository
): ViewModel(){


    companion object{
        private const val DEFAULT_QUERY = "Nature"
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchReasults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query : String) {
        currentQuery.value = query
    }
}