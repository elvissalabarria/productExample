package com.elvissalabarria.shopproducts.domain

import com.elvissalabarria.shopproducts.data.ProductRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): List<String> {
        return repository.getAllCategories()
    }
}