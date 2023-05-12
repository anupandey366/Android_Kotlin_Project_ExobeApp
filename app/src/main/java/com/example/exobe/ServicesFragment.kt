package com.example.exobe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_category.view.*
import kotlinx.android.synthetic.main.fragment_services.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ServicesFragment : Fragment(), ProductViewClick {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_services, container, false)

        val arrServices = ArrayList<RecyclerModel>()

        arrServices.add(RecyclerModel(R.drawable.electrician,"Electrician"))
        arrServices.add(RecyclerModel(R.drawable.plumberr,"Plumber"))
        arrServices.add(RecyclerModel(R.drawable.uni_salon,"Uni-Salon"))

        arrServices.add(RecyclerModel(R.drawable.telecom,"Telecom"))
        arrServices.add(RecyclerModel(R.drawable.carpenterr,"Carpenter"))
        arrServices.add(RecyclerModel(R.drawable.cleaning,"Cleaning"))

        arrServices.add(RecyclerModel(R.drawable.electrician,"Electrician"))
        arrServices.add(RecyclerModel(R.drawable.plumberr,"Plumber"))
        arrServices.add(RecyclerModel(R.drawable.uni_salon,"Uni-Salon"))

        arrServices.add(RecyclerModel(R.drawable.telecom,"Telecom"))
        arrServices.add(RecyclerModel(R.drawable.carpenterr,"Carpenter"))
        arrServices.add(RecyclerModel(R.drawable.cleaning,"Cleaning"))



        v.rv_Services.layoutManager = GridLayoutManager(v.context,3)

        val recyclerAdapter = RecyclerCategoryAdapter(v.context,arrServices,this)
        v.rv_Services.adapter = recyclerAdapter





        return v
    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ServicesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}