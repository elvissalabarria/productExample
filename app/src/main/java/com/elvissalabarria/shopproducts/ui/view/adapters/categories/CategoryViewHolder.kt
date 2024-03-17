package com.elvissalabarria.shopproducts.ui.view.adapters.categories

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.elvissalabarria.shopproducts.databinding.ItemCategoryBinding

class CategoryViewHolder(view: View) : ViewHolder(view) {
    private val binding = ItemCategoryBinding.bind(view)
    fun render(category: String, onClickListener: (String) -> Unit) {
        binding.tvCategory.text = category
        itemView.setOnClickListener {
            onClickListener(category)
        }
    }

}
