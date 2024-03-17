package com.elvissalabarria.shopproducts.ui.view.adapters.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elvissalabarria.shopproducts.R
import com.elvissalabarria.shopproducts.data.model.ProductModelItem

class ProductAdapter(
    private val productList: List<ProductModelItem>,
    private val onClickListener: (ProductModelItem) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))

    }

    override fun getItemCount(): Int =
        productList.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.render(item, onClickListener)
    }
}