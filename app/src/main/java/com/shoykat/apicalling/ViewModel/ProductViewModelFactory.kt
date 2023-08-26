package com.shoykat.apicalling.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoykat.apicalling.Repos.ProductRepository

class ProductViewModelFactory(private val productRepository: ProductRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository )as T
    }
}