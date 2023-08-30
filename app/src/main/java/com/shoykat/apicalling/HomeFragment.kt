package com.shoykat.apicalling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shoykat.apicalling.Api.ApiInterface
import com.shoykat.apicalling.Api.Retrofithelper
import com.shoykat.apicalling.Repos.ProductRepository
import com.shoykat.apicalling.ViewModel.ProductViewModel
import com.shoykat.apicalling.ViewModel.ProductViewModelFactory
import com.shoykat.apicalling.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding :FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productViewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(createProductRepository())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        recyclerView = binding.recyclerView
        productAdapter = ProductAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = productAdapter

        // Observe the LiveData from the ViewModel
        productViewModel.products.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }
        return binding.root

    }
    private fun createProductRepository(): ProductRepository {
        val apiInterface = Retrofithelper.getProductInstance().create(ApiInterface::class.java)
        return ProductRepository(apiInterface)

    }

}