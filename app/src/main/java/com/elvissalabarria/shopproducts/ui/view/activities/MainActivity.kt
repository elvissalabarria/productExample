package com.elvissalabarria.shopproducts.ui.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvissalabarria.shopproducts.data.model.CategoryModelItem
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.databinding.ActivityMainBinding
import com.elvissalabarria.shopproducts.ui.view.adapters.categories.CategoryAdapter
import com.elvissalabarria.shopproducts.ui.view.adapters.products.ProductAdapter
import com.elvissalabarria.shopproducts.ui.viewmodels.CategoryViewModel
import com.elvissalabarria.shopproducts.ui.viewmodels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val productViewModel: ProductViewModel by viewModels()
    private val categoryViewModel: CategoryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        categoryViewModel.onCreate()
        productViewModel.onCreate()
        initAppBar()
        initRecyclerViewCategory(categoryViewModel)
        initRecyclerView(productViewModel)
    }

    private fun initAppBar() {
        setSupportActionBar(binding.toolBar)
        title = "Shop Products"
    }

    private fun initRecyclerViewCategory(categoryViewModel: CategoryViewModel) {
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryViewModel.categoriesModel.observe(this) { it ->
            binding.recyclerCategories.layoutManager = manager
            binding.recyclerCategories.adapter = CategoryAdapter(it) {
                onCategorySelected(it)
            }

        }
    }

    private fun onCategorySelected(category: CategoryModelItem) {
        Toast.makeText(this, category.category, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView(productViewModel: ProductViewModel) {

        val manager = GridLayoutManager(this, 3)
        productViewModel.productModel.observe(this) { it ->
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