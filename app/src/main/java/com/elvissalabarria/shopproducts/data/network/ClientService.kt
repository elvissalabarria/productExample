package com.elvissalabarria.shopproducts.data.network

import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.data.model.Rating
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClientService @Inject constructor(
    private val apiClient: ApiClient
) {
    suspend fun getAllProducts(): List<ProductModelItem> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllProducts()
            response.body() ?: emptyList()
        }
    }

    suspend fun getAllCategories(): List<String> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllCategories()
            response.body() ?: emptyList()
        }
    }

    suspend fun getProductById(id: Int): ProductModelItem {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getProductById(id)
            response.body() ?: ProductModelItem(
                id = 0,
                category = "",
                description = "",
                image = "",
                price = 0.0,
                title = "",
                rating = Rating(
                    rate = 0.0,
                    count = 0
                )

            )
        }
    }
}