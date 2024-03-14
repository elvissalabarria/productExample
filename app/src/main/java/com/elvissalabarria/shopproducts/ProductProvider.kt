package com.elvissalabarria.shopproducts

class ProductProvider {
    companion object {
        val products = listOf(
            Product(
                "Shirt",
                19.99,
                "A nice shirt",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            ),
            Product(
                "Pants",
                29.99,
                "A nice pair of pants",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            ),
            Product(
                "Shoes",
                39.99,
                "A nice pair of shoes",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
    }
}