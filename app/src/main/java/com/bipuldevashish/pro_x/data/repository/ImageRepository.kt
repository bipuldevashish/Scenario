package com.bipuldevashish.pro_x.data.repository

import com.bipuldevashish.pro_x.data.api.RetrofitBuilder
import com.bipuldevashish.pro_x.data.local.ImageDatabase

class ImageRepository(val db : ImageDatabase) {

            suspend fun getImagesResults(api_key : String, page : Int, per_page : Int) =
                    RetrofitBuilder.api.getImageResults(api_key, page, per_page)

}