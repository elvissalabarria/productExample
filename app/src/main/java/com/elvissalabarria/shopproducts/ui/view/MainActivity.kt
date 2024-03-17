package com.elvissalabarria.shopproducts.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.databinding.ActivityMainBinding
import com.elvissalabarria.shopproducts.ui.view.adapter.ProductAdapter
import com.elvissalabarria.shopproducts.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val productViewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel.onCreate()
        initAppBar()
        initRecyclerView(productViewModel)
    }

    private fun initAppBar() {
        setSupportActionBar(binding.toolBar)
        title = "Shop Products"
    }

    private fun initRecyclerView(productViewModel: ProductViewModel) {

        val manager = GridLayoutManager(this, 3)
        productViewModel.productModel.observe(this) {
            binding.recyclerProducts.layoutManager = manager
            binding.recyclerProducts.adapter = ProductAdapter(it) {
                onItemSelected(
                    it
                )
            }

        }
        productViewModel.isLoading.observe(this) {
            binding.progress.isVisible = it
        }

    }

    private fun onItemSelected(product: ProductModelItem) {
        val intent = Intent(this, DetailProduct::class.java)
        startActivity(intent)
    }
}