package com.shoykat.apicalling.ViewModel


import androidx.lifecycle.viewModelScope
import com.shoykat.apicalling.Repos.ProductRepository
import com.shoykat.apicalling.models.Product
import com.shoykat.apicalling.models.ProductItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
/*class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    *//*private val _products = MutableLiveData<List<ProductItem>>()
    val productxs: LiveData<List<ProductItem>> get() = _products*//*
    val products: LiveData<List<ProductItem>>
        get() = repository.products

    private val _selectedProduct = MutableLiveData<ProductItem>()
    val selectedProduct: LiveData<ProductItem> get() = _selectedProduct

    fun loadProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllProduct()
        }
    }

    fun loadProductById(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProductById(productId)
        }
    }
}*/



class ProductViewModel(val productrepository: ProductRepository) :ViewModel(){
    val products: LiveData<List<ProductItem>>
        get() = productrepository.products

   init {
       viewModelScope.launch (Dispatchers.IO){
           productrepository.getAllProduct()
       }
       viewModelScope.launch (Dispatchers.IO){
           productrepository.getProductById(productId =2)
       }
   }


}
