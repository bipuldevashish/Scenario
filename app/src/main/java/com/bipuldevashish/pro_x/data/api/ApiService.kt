package com.bipuldevashish.pro_x.data.api

import com.bipuldevashish.pro_x.data.models.ImageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

/*
* getImageResults :  This is a "GET" call with "curated/" endpoint which will be
* utilised by ApiService. This contains 3 parameters in it's call
*
* key : API KEY for authentication purpose
* page : this is a parameter for getting data by paginated
* per_page : This defines the number of images we want per API call.
*
* */
    @GET("curated/")
    suspend fun getImageResults(
        @Query("key") key: String?,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<ImageList>

}