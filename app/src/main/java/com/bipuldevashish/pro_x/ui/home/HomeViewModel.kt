package com.bipuldevashish.pro_x.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bipuldevashish.pro_x.data.repository.PexelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PexelRepository
) : ViewModel() {
    val photos = repository.getImageResults().cachedIn(viewModelScope)
}


