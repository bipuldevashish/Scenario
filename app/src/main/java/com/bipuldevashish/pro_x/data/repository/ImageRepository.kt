package com.bipuldevashish.pro_x.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.bipuldevashish.pro_x.data.api.ApiService
import com.bipuldevashish.pro_x.data.api.RetrofitBuilder
import com.bipuldevashish.pro_x.data.local.ImageDatabase
import com.bipuldevashish.pro_x.data.paging.PexelPagingSource
import javax.inject.Inject
import javax.inject.Singleton

class ImageRepository(val db : ImageDatabase) {

            suspend fun getImagesResults(page : Int, per_page : Int) =
                    RetrofitBuilder.api.getImageResults(page, per_page)

}

@Singleton
class PexelRepository @Inject constructor(private val apiService: ApiService){

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