package com.elvissalabarria.shopproducts.ui.view.adapters.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elvissalabarria.shopproducts.R
import com.elvissalabarria.shopproducts.data.model.CategoryModelItem

class CategoryAdapter (
    private val categoryList: List<CategoryModelItem>,
    private val onClickListener: (CategoryModelItem) -> Unit
):RecyclerView.Adapter<CategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = categoryList[position]
        holder.render(item, onClickListener, categoryList)
    }
}