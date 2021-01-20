package com.bipuldevashish.pro_x.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.bipuldevashish.pro_x.data.api.ApiService
import com.bipuldevashish.pro_x.data.paging.PagingSourceCurated
import com.bipuldevashish.pro_x.data.paging.PexelPagingSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PexelRepository @Inject constructor(private val apiService: ApiService){

        fun getImageResults() =
                Pager(
                        config = PagingConfig(
                                pageSize = 30,
                                maxSize = 100,
                                enablePlaceholders = false
                        ),
                        pagingSourceFactory = {PagingSourceCurated(apiService)}
                ).liveData

        fun getSearchReasults(query: String)=
                Pager(
                        config = PagingConfig(
                                pageSize = 30,
                                maxSize = 100,
                                enablePlaceholders = false
                        ),
                        pagingSourceFactory = {PexelPagingSource(apiService, query)}
                ).liveData
}