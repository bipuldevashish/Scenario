package com.bipuldevashish.pro_x.data.repository

import com.bipuldevashish.pro_x.data.api.RetrofitBuilder
import com.bipuldevashish.pro_x.data.local.ImageDatabase

class ImageRepository(val db : ImageDatabase) {

            suspend fun getImagesResults(api_key : String, query: String, page : Int, per_page : Int) =
                    RetrofitBuilder.api.getImageResults(api_key, query, page, per_page)

}