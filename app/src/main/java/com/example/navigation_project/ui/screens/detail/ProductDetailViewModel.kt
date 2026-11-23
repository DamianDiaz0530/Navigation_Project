package com.example.navigation_project.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.navigation_project.data.Product
import com.example.navigation_project.data.products
import com.example.navigation_project.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class ProductDetailState(
    val product: Product? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class ProductDetailViewModel(
    productId: Int,
) : BaseViewModel<ProductDetailState>(ProductDetailState()) {

    init {
        loadProduct(productId)
    }

    private fun loadProduct(productId: Int) {
        updateState { copy(isLoading = true, error = null) }
        
        // Simulate network/database call
        viewModelScope.launch {
            try {
                // Simulate network delay
                delay(500)
                
                // In a real app, this would be a repository call
                val product = products.find { it.id == productId }
                
                if (product != null) {
                    updateState { 
                        copy(
                            product = product,
                            isLoading = false
                        ) 
                    }
                } else {
                    updateState { 
                        copy(
                            isLoading = false, 
                            error = "Product not found"
                        ) 
                    }
                }
            } catch (e: Exception) {
                updateState { 
                    copy(
                        isLoading = false, 
                        error = "Error loading product: ${e.message}"
                    ) 
                }
            }
        }
    }
}
