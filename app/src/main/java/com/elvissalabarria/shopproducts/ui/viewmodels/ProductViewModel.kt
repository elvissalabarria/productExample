package com.elvissalabarria.shopproducts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.domain.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val productModel = MutableLiveData<List<ProductModelItem>>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getProductUseCase()
            if (result.isNotEmpty()) {
                productModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}