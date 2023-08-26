package com.shoykat.apicalling.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofithelper  {
    const val  Base_url ="https://fakestoreapi.com/"

    fun  getProductInstance():Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}