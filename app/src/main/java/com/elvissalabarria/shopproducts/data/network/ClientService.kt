package com.elvissalabarria.shopproducts.data.network

import com.elvissalabarria.shopproducts.data.model.ProductModelItem
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
}