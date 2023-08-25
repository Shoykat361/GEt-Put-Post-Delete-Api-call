package com.shoykat.apicalling

import com.shoykat.apicalling.models.Product

interface Api {
    @Get
    @Query("/products")
    suspend fun getproduct():Response<Product>
}