package com.example.exobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.product_lists.*

class ProductList : AppCompatActivity(), ProductViewClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_lists)

        iv_backArrow.setOnClickListener {
            finish()
        }

        val arrProduct = ArrayList<RecyclerProductModel>()

        arrProduct.add(RecyclerProductModel(R.drawable.product_1,"Furniture","$400"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_2b,"Shoes","$999"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_3b,"Phones","$599"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_4,"Clothes","$599"))

        arrProduct.add(RecyclerProductModel(R.drawable.product_1,"Furniture","$400"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_2b,"Shoes","$999"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_3b,"Phones","$599"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_4,"Clothes","$599"))

        arrProduct.add(RecyclerProductModel(R.drawable.product_1,"Furniture","$400"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_2b,"Shoes","$999"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_3b,"Phones","$599"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_4,"Clothes","$599"))

        arrProduct.add(RecyclerProductModel(R.drawable.product_1,"Furniture","$400"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_2b,"Shoes","$999"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_3b,"Phones","$599"))
        arrProduct.add(RecyclerProductModel(R.drawable.product_4,"Clothes","$599"))


        rv_Product.layoutManager= GridLayoutManager(this,2)
        val recyclerAdapter = ProductAdapter(this,arrProduct,this)
        rv_Product.adapter= recyclerAdapter
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}