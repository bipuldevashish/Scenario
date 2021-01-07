package com.bipuldevashish.pro_x.data.repository

import com.bipuldevashish.pro_x.data.api.RetrofitBuilder
import com.bipuldevashish.pro_x.data.local.ImageDatabase

class ImageRepository(val db : ImageDatabase) {

            suspend fun getImagesResults(page : Int, per_page : Int) =
                    RetrofitBuilder.api.getImageResults(page, per_page)

            suspend fun getSearchReasults(query : String, page: Int, per_page: Int) =
                    RetrofitBuilder.api.getSearchReasults(query, page, per_page)
}