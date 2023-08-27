package com.shoykat.apicalling.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoykat.apicalling.Repos.ProductRepository
import com.shoykat.apicalling.models.Product
import com.shoykat.apicalling.models.ProductItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get

class ProductViewModel(val productrepository: ProductRepository) :ViewModel(){
   init {
       viewModelScope.launch (Dispatchers.IO){
           productrepository.getProduct()
       }
   }
    val products: LiveData<List<ProductItem>>
     get() = productrepository.products
}