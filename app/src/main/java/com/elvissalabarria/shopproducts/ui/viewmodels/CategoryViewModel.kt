package com.elvissalabarria.shopproducts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvissalabarria.shopproducts.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoriesUseCase
) : ViewModel() {
    val categoriesModel = MutableLiveData<List<String>>()
    private val original = mutableListOf("All")

    fun onCreate() {
        viewModelScope.launch {
            val categories = getCategoryUseCase()
            original.addAll(categories)
            if (categories.isNotEmpty()) {
                categoriesModel.postValue(original)
            }
        }
    }
}
