package com.elvissalabarria.shopproducts.data

import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.data.network.ClientService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val clientService: ClientService
) {
    suspend fun getAllProducts(): List<ProductModelItem> {
        return clientService.getAllProducts()
    }

    suspend fun getAllCategories(): List<String> {
        return clientService.getAllCategories()
    }
}