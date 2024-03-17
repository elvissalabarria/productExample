package com.elvissalabarria.shopproducts.ui.view.adapters.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.databinding.ItemProductBinding

class ProductViewHolder(view: View) : ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)

    fun render(productModel: ProductModelItem, onClickListener: (ProductModelItem) -> Unit) {
        binding.tvProductName.text = productModel.title
        binding.tvProductPrice.text = "$${productModel.price}"
        Glide.with(binding.imgProduct.context)
            .load(productModel.image)
            .into(binding.imgProduct)

        binding.tvRating.text = productModel.rating.rate.toString()
        itemView.setOnClickListener {
            onClickListener(productModel)
        }
    }

}