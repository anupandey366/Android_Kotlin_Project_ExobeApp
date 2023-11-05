package com.example.exobe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_page.*

class CategoryFragment : Fragment(), ProductViewClick {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_category, container, false)


        val arrCategory = ArrayList<RecyclerModel>()

        arrCategory.add(RecyclerModel(R.drawable.furniture,"Furniture"))
        arrCategory.add(RecyclerModel(R.drawable.shoes,"Shoes"))
        arrCategory.add(RecyclerModel(R.drawable.phones,"Phones"))
        arrCategory.add(RecyclerModel(R.drawable.clothes,"Clothes"))

        arrCategory.add(RecyclerModel(R.drawable.furniture,"Furniture"))
        arrCategory.add(RecyclerModel(R.drawable.shoes,"Shoes"))
        arrCategory.add(RecyclerModel(R.drawable.phones,"Phones"))
        arrCategory.add(RecyclerModel(R.drawable.clothes,"Clothes"))

        arrCategory.add(RecyclerModel(R.drawable.furniture,"Furniture"))
        arrCategory.add(RecyclerModel(R.drawable.shoes,"Shoes"))
        arrCategory.add(RecyclerModel(R.drawable.phones,"Phones"))
        arrCategory.add(RecyclerModel(R.drawable.clothes,"Clothes"))

        arrCategory.add(RecyclerModel(R.drawable.furniture,"Furniture"))
        arrCategory.add(RecyclerModel(R.drawable.shoes,"Shoes"))
        arrCategory.add(RecyclerModel(R.drawable.phones,"Phones"))
        arrCategory.add(RecyclerModel(R.drawable.clothes,"Clothes"))

        v.recyclerView.layoutManager = GridLayoutManager(v.context,4)

        val recyclerAdapter = RecyclerCategoryAdapter(v.context,arrCategory,this)
        v.recyclerView.adapter = recyclerAdapter

        return v

    }



    override fun viewProducts(name: String, type: String, price: Int) {

    }
}