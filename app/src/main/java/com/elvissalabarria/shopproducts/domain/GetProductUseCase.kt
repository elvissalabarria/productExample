package com.elvissalabarria.shopproducts.domain

import com.elvissalabarria.shopproducts.data.ProductRepository
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<ProductModelItem> {
        return repository.getAllProducts()
    }

}