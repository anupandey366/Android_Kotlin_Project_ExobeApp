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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CategoryFragment : Fragment(), ProductViewClick {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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



    companion object {
        
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}