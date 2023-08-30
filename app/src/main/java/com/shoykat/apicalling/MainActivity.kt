package com.shoykat.apicalling

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoykat.apicalling.Api.ApiInterface
import com.shoykat.apicalling.Api.Retrofithelper
import com.shoykat.apicalling.Repos.ProductRepository
import com.shoykat.apicalling.ViewModel.ProductViewModel
import com.shoykat.apicalling.ViewModel.ProductViewModelFactory
import com.shoykat.apicalling.models.ProductItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    /*private lateinit var productViewModel: ProductViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* val apiInterface =Retrofithelper.getProductInstance().create(ApiInterface::class.java)
        val productRepository=ProductRepository(apiInterface)
        //productViewModel=ViewModelProvider(this,ProductViewModelFactory(productRepository)).get(ProductViewModel)
        productViewModel = ViewModelProvider(this, ProductViewModelFactory(productRepository))
            .get(ProductViewModel::class.java)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        productAdapter = ProductAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter
        productViewModel.products.observe(this) {

            productAdapter?.submitList(it)

        }


*/
    }
}