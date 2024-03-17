package com.elvissalabarria.shopproducts.data.network

import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("/products")
    suspend fun getAllProducts(): Response<List<ProductModelItem>>

    @GET("/products/categories")
    suspend fun getAllCategories(): Response<List<String>>
}