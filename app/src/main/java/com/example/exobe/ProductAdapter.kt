package com.example.exobe

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_list_layout.view.*

class ProductAdapter(val context: Context, val arrProduct: ArrayList<RecyclerProductModel>, val click: ProductViewClick) : RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*val imgCategory = itemView.iv_category
        val txtCategoryName = itemView.tv_CategoryName*/
        val imgCategory = itemView.iv_product
        val txtCategoryName = itemView.tv_productName
        val txtProductPrice = itemView.tv_productPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_list_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCategory.setImageResource(arrProduct[position].img)
        holder.txtCategoryName.text = arrProduct[position].name
        holder.txtProductPrice.text = arrProduct[position].price

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,CollapsedProductDetail::class.java))
        }
    }

}