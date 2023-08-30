package com.shoykat.apicalling.Api

import com.shoykat.apicalling.models.Product
import com.shoykat.apicalling.models.ProductItem
import okhttp3.Request
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("products")
     suspend fun getProduct():Response<List<ProductItem>>
    @GET("products/{productId}")
    suspend fun getProductById(@Path("productId") productId: Int): Response<List<ProductItem>>



}