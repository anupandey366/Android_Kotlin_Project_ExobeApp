package com.example.exobe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_home.view.image_slider
import kotlinx.android.synthetic.main.fragment_home.view.iv_chair
import kotlinx.android.synthetic.main.fragment_home.view.iv_headphone
import kotlinx.android.synthetic.main.fragment_home.view.iv_mobile
import kotlinx.android.synthetic.main.fragment_home.view.iv_sofa
import kotlinx.android.synthetic.main.fragment_home.view.recyclerViewCategory
import kotlinx.android.synthetic.main.fragment_home.view.recyclerViewServices
import kotlinx.android.synthetic.main.fragment_home.view.tv_seeAllCategories
import kotlinx.android.synthetic.main.fragment_home.view.tv_seeAllPopular
import kotlinx.android.synthetic.main.fragment_home.view.tv_seeAllServices

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : androidx.fragment.app.Fragment(), ProductViewClick {

    lateinit var image_slider: ImageSlider
    var sliderList: ArrayList<SlideModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_home, container, false)


        v.iv_chair.setOnClickListener {
            val intent = Intent(v.context,CollapsedProductDetail::class.java)
            startActivity(intent)
        }

        v.iv_headphone.setOnClickListener {
            val intent = Intent(v.context,CollapsedProductDetail::class.java)
            startActivity(intent)
        }

        v.iv_mobile.setOnClickListener {
            val intent = Intent(v.context,CollapsedProductDetail::class.java)
            startActivity(intent)
        }

        v.iv_sofa.setOnClickListener {
            val intent = Intent(v.context,CollapsedProductDetail::class.java)
            startActivity(intent)
        }

        v.tv_seeAllCategories.setOnClickListener {
            val intent = Intent(v.context,Home_Page::class.java)
            intent.putExtra("goToFragment" ,"homeToCategory")
            startActivity(intent)
        }

        v.tv_seeAllPopular.setOnClickListener {
            val intent = Intent(v.context,Home_Page::class.java)
            intent.putExtra("goToPopular" ,"homeToPopular")
            startActivity(intent)
        }

        v.tv_seeAllServices.setOnClickListener {
            val intent = Intent(v.context,Home_Page::class.java)
            intent.putExtra("goToServices" ,"homeToServices")
            startActivity(intent)
        }

        /////////////////////////////////////////////////////////////

        sliderList.clear()

        sliderList.add(SlideModel(R.drawable.slider1))
        sliderList.add(SlideModel(R.drawable.slider1))
        sliderList.add(SlideModel(R.drawable.slider1))
        sliderList.add(SlideModel(R.drawable.slider1))
        sliderList.add(SlideModel(R.drawable.slider1))


        v.image_slider.setImageList(sliderList, ScaleTypes.CENTER_CROP)


        /////////////////////////////////////////////////////////////////////////

        val arrCategory = ArrayList<RecyclerModel>()

        arrCategory.add(RecyclerModel(R.drawable.electronics,"Electronics"))
        arrCategory.add(RecyclerModel(R.drawable.beauty,"Beauty"))
        arrCategory.add(RecyclerModel(R.drawable.fashion,"Fashion"))
        arrCategory.add(RecyclerModel(R.drawable.groceries,"Groceries"))
        arrCategory.add(RecyclerModel(R.drawable.toys,"Toys"))

        arrCategory.add(RecyclerModel(R.drawable.electronics,"Electronics"))
        arrCategory.add(RecyclerModel(R.drawable.beauty,"Beauty"))
        arrCategory.add(RecyclerModel(R.drawable.fashion,"Fashion"))
        arrCategory.add(RecyclerModel(R.drawable.groceries,"Groceries"))
        arrCategory.add(RecyclerModel(R.drawable.toys,"Toys"))

        arrCategory.add(RecyclerModel(R.drawable.electronics,"Electronics"))
        arrCategory.add(RecyclerModel(R.drawable.beauty,"Beauty"))
        arrCategory.add(RecyclerModel(R.drawable.fashion,"Fashion"))
        arrCategory.add(RecyclerModel(R.drawable.groceries,"Groceries"))
        arrCategory.add(RecyclerModel(R.drawable.toys,"Toys"))

        arrCategory.add(RecyclerModel(R.drawable.electronics,"Electronics"))
        arrCategory.add(RecyclerModel(R.drawable.beauty,"Beauty"))
        arrCategory.add(RecyclerModel(R.drawable.fashion,"Fashion"))
        arrCategory.add(RecyclerModel(R.drawable.groceries,"Groceries"))
        arrCategory.add(RecyclerModel(R.drawable.toys,"Toys"))

        v.recyclerViewCategory.layoutManager = LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)

        val recyclerCategoryAdapter = RecyclerCategoryAdapter(v.context,arrCategory,this)
        v.recyclerViewCategory.adapter = recyclerCategoryAdapter


        ////////////////////////////////////////////////////////////////////////////////////////////////////

        val arrServices = ArrayList<RecyclerModel>()

        arrServices.add(RecyclerModel(R.drawable.plumber,"Plumbers"))
        arrServices.add(RecyclerModel(R.drawable.electrical,"Electricals"))
        arrServices.add(RecyclerModel(R.drawable.carpenter_b,"Carpenters"))

        arrServices.add(RecyclerModel(R.drawable.plumber,"Plumbers"))
        arrServices.add(RecyclerModel(R.drawable.electrical,"Electricals"))
        arrServices.add(RecyclerModel(R.drawable.carpenter_b,"Carpenters"))

        arrServices.add(RecyclerModel(R.drawable.plumber,"Plumbers"))
        arrServices.add(RecyclerModel(R.drawable.electrical,"Electricals"))
        arrServices.add(RecyclerModel(R.drawable.carpenter_b,"Carpenters"))

        arrServices.add(RecyclerModel(R.drawable.plumber,"Plumbers"))
        arrServices.add(RecyclerModel(R.drawable.electrical,"Electricals"))
        arrServices.add(RecyclerModel(R.drawable.carpenter_b,"Carpenters"))

        arrServices.add(RecyclerModel(R.drawable.plumber,"Plumbers"))
        arrServices.add(RecyclerModel(R.drawable.electrical,"Electricals"))
        arrServices.add(RecyclerModel(R.drawable.carpenter_b,"Carpenters"))


        v.recyclerViewServices.layoutManager = LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)

        val recyclerServicesAdapter = RecyclerServicesAdapter(v.context,arrServices)
        v.recyclerViewServices.adapter = recyclerServicesAdapter


        return v

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }


    /*   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
           super.onViewCreated(view, savedInstanceState)
       }*/


}

