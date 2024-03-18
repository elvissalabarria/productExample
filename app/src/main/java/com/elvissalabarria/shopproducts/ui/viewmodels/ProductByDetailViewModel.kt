package com.elvissalabarria.shopproducts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvissalabarria.shopproducts.data.model.ProductModelItem
import com.elvissalabarria.shopproducts.domain.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductByDetailViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase
) : ViewModel() {
    private val isLoading = MutableLiveData<Boolean>()
    private val productModelDetail = MutableLiveData<ProductModelItem>()

    fun onCreate(productId: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getProductByIdUseCase(id = productId)
            productModelDetail.postValue(result)
            isLoading.postValue(false)
        }
    }

}