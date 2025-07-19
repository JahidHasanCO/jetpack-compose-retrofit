package com.example.jetpackcomposeretrofit.data.remote.api

import com.example.jetpackcomposeretrofit.data.model.Cat
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/cats")
    suspend fun getCatList(@Query("name") name: String): List<Cat>
}