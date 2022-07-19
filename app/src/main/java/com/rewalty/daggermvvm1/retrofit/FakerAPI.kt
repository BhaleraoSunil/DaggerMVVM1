package com.rewalty.daggermvvm1.retrofit

import com.rewalty.daggermvvm1.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProduces(): Response<List<Products>>
}