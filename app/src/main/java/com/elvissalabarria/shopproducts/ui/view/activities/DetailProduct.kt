package com.elvissalabarria.shopproducts.ui.view.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.elvissalabarria.shopproducts.databinding.ActivityDetailProductBinding
import com.elvissalabarria.shopproducts.ui.viewmodels.ProductByDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailProduct : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    private val productByDetailViewModel: ProductByDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAppBar()
        val productId:String = intent.getStringExtra("product_id").toString()

        productByDetailViewModel.onCreate(productId.toInt())

    }

    private fun initAppBar() {
        setSupportActionBar(binding.appBarDetailProduct)
        title = "Detail Product"
    }
}