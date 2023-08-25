package com.shoykat.apicalling

import com.shoykat.apicalling.models.ProductItem
import okhttp3.Request
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("products")
     fun getProduct():Call<List<ProductItem>>
     /*@POST("products")
     fun postProduct(@Body product: ProductItem): Call<Request>*/

}