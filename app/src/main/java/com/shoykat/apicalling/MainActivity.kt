package com.shoykat.apicalling

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.shoykat.apicalling.models.ProductItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val base_Url ="https://fakestoreapi.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getProduct()


    }

    private fun getProduct() {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_Url) // Replace with your API's base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitGetproduct =retrofit.getProduct()
        retrofitGetproduct.enqueue(object : Callback<List<ProductItem>?> {
            override fun onResponse(
                call: Call<List<ProductItem>?>,
                response: Response<List<ProductItem>?>
            ) {
                val responseBody = response.body()!!
                val myStringBuilder=StringBuilder()
                Log.d("MainActivity","${responseBody.size}")
                for (mydata in responseBody){
                   /* myStringBuilder.append(mydata.id)
                    myStringBuilder.append(mydata.title)
                    myStringBuilder.append(mydata.category)
                    myStringBuilder.append(mydata.description)*/
                    //myStringBuilder.append(mydata.image)
                    myStringBuilder.append(mydata.price)

                    myStringBuilder.append("\n")
                    /*myStringBuilder.append(mydata.rating)*/

                }
                var x =findViewById<TextView>(R.id.textView2)
                x.text=myStringBuilder
            }

            override fun onFailure(call: Call<List<ProductItem>?>, t: Throwable) {
                Log.d("MainActivity","fail")

            }
        })



    }
}