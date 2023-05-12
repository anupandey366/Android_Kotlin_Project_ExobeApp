package com.example.exobe

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_layout.view.*

class RecyclerCategoryAdapter(val context: Context, val arrCategory: ArrayList<RecyclerModel>, val click: ProductViewClick ) : RecyclerView.Adapter<RecyclerCategoryAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategory = itemView.iv_category
        val txtCategoryName = itemView.tv_CategoryName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCategory.setImageResource(arrCategory[position].img)
        holder.txtCategoryName.text = arrCategory[position].name

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,ProductList::class.java))
        }

    }

}