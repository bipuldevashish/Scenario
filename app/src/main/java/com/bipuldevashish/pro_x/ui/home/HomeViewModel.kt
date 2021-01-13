package com.bipuldevashish.pro_x.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bipuldevashish.pro_x.data.repository.PexelRepository

class HomeViewModel @ViewModelInject constructor(
    private val repository: PexelRepository
) : ViewModel() {
    val photos = repository.getImageResults().cachedIn(viewModelScope)
}


