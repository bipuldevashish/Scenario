package com.bipuldevashish.pro_x.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        const val BASE_URL = "https://api.pexels.com/v1/"

        private val retrofit by lazy {
            val client = OkHttpClient.Builder()
                    .build()
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }

        val api by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}