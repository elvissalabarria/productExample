package com.elvissalabarria.shopproducts.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvissalabarria.shopproducts.Product
import com.elvissalabarria.shopproducts.ProductProvider
import com.elvissalabarria.shopproducts.ui.view.adapter.ProductAdapter
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.databinding.ActivityMainBinding
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
        initRecyclerView(productViewModel)
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
    }

    private fun onItemSelected(product: ProductModelItem) {
        Toast.makeText(this, product.title, Toast.LENGTH_SHORT).show()
    }
}