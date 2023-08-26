package com.shoykat.apicalling.Api

import com.shoykat.apicalling.models.Product
import com.shoykat.apicalling.models.ProductItem
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("products")
     suspend fun getProduct():Response<List<ProductItem>>


}