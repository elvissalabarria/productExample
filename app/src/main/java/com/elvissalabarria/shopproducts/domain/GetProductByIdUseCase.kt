package com.elvissalabarria.shopproducts.domain

import com.elvissalabarria.shopproducts.data.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val repository: ProductRepository
){
    suspend operator fun invoke(id: Int) = repository.getProductById(id)
}