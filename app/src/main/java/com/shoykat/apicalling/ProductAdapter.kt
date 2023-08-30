package com.shoykat.apicalling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shoykat.apicalling.models.ProductItem

class ProductAdapter :
    ListAdapter<ProductItem, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_row, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        val context = holder.itemView.context
        holder.bind(product)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Item clicked: ${product.price}", Toast.LENGTH_SHORT).show()
        }
    }




    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // private val titleTextView: TextView = itemView.findViewById(R.id.showTitle)
        private val priceTextView: TextView = itemView.findViewById(R.id.showPrice)
       // private val detailsTextView: TextView = itemView.findViewById(R.id.showDetails)
        private val categoryTextView: TextView = itemView.findViewById(R.id.showcategory)

        fun bind(product: ProductItem) {
            //titleTextView.text = product.title.toString()
            priceTextView.text = product.price.toString()
            //detailsTextView.text = product.description .toString()
            categoryTextView.text = product.category .toString()
        }
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }
}