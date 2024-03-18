package com.elvissalabarria.shopproducts.data.model

class CategoryModel : ArrayList<ProductModelItem>()
data class CategoryModelItem(
    val category: String,
    var isSelected: Boolean
)