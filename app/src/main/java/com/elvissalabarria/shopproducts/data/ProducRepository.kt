package com.elvissalabarria.shopproducts.data

import com.elvissalabarria.shopproducts.Product
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.data.network.ApiClient
import com.elvissalabarria.shopproducts.data.network.ClientService
import javax.inject.Inject

class ProducRepository @Inject constructor(
    private val clientService: ClientService
) {
    suspend fun getAllProducts(): List<ProductModelItem> {
        val response: List<ProductModelItem> = clientService.getAllProducts()
        return response
    }
}