package com.shoykat.apicalling.Repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shoykat.apicalling.Api.ApiInterface
import com.shoykat.apicalling.models.Product
import com.shoykat.apicalling.models.ProductItem
import retrofit2.Response

class ProductRepository(val apiInterface: ApiInterface) {
    private val productLiveData = MutableLiveData<List<ProductItem>>()
    val products : LiveData<List<ProductItem>>
    get() = productLiveData
    suspend fun getAllProduct(){
        val result = apiInterface.getProduct()
        if (result.body()!=null){
            productLiveData.postValue(result.body())
        }
    }
    suspend fun getProductById(productId:Int):ProductItem?{
        val result = apiInterface.getProductById(productId)
        if (result.isSuccessful) {
            val productList = result.body()
            return productList?.firstOrNull()
        }
        return null
    }
}