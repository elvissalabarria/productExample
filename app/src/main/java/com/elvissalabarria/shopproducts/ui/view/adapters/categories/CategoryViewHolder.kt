package com.elvissalabarria.shopproducts.ui.view.adapters.categories

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.elvissalabarria.shopproducts.R
import com.elvissalabarria.shopproducts.data.model.CategoryModelItem
import com.elvissalabarria.shopproducts.databinding.ItemCategoryBinding

class CategoryViewHolder(view: View) : ViewHolder(view) {
    private val binding = ItemCategoryBinding.bind(view)
    fun render(
        category: CategoryModelItem,
        onClickListener: (CategoryModelItem) -> Unit,
        categoryList: List<CategoryModelItem>
    ) {
        binding.tvCategory.text = category.category
        if (category.isSelected) {
            binding.cvCategory.setCardBackgroundColor(binding.root.context.resources.getColor(R.color.purple))
            binding.tvCategory.setTextColor(binding.root.context.resources.getColor(R.color.white))

        }
        itemView.setOnClickListener {
            onClickListener(category)
            setIsSelected(category, categoryList)
        }
    }

    private fun setIsSelected(category: CategoryModelItem, categoryList: List<CategoryModelItem>) {
            category.isSelected = !category.isSelected
            if (category.isSelected) {
                binding.cvCategory.setCardBackgroundColor(binding.root.context.resources.getColor(R.color.purple))
                binding.tvCategory.setTextColor(binding.root.context.resources.getColor(R.color.white))
            } else {
                binding.cvCategory.setCardBackgroundColor(binding.root.context.resources.getColor(R.color.white))
                binding.tvCategory.setTextColor(binding.root.context.resources.getColor(R.color.black))
            }
            categoryList.forEach {
                if (it != category) {
                    it.isSelected = false
                }
            }
    }
}
