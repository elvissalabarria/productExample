package com.elvissalabarria.shopproducts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvissalabarria.shopproducts.data.model.CategoryModelItem
import com.elvissalabarria.shopproducts.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoriesUseCase
) : ViewModel() {
    val categoriesModel = MutableLiveData<List<CategoryModelItem>>()
    private val original = mutableListOf<CategoryModelItem>(
        CategoryModelItem("All", true)

    )

    fun onCreate() {
        viewModelScope.launch {
            val categories = getCategoryUseCase()
            categories.map {
                original.add(CategoryModelItem(it, false))
            }

            if (categories.isNotEmpty()) {
                categoriesModel.postValue(original)
            }
        }
    }
}
