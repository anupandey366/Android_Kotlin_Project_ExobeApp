package com.example.exobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.tabs
import kotlinx.android.synthetic.main.activity_main.viewPager
import kotlinx.android.synthetic.main.collapse_product_detail.*


class CollapsedProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collapse_product_detail)

        iv_backBtn.setOnClickListener {
            finish()
        }
        iv_backArrowWhite.setOnClickListener {
            finish()
        }

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FragmentDescription(), "Description")
        adapter.addFragment(FragmentMaterials(), "Materials")
        adapter.addFragment(FragmentReviews(), "Reviews")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)

        var count = 0

        tv_quantity.setText("" + count)

        iv_plus.setOnClickListener {
            if(count > -1) {
                tv_quantity.setText("" + ++count)
            }
        }

        iv_minus.setOnClickListener {
            if(count > 0) {
                tv_quantity.setText("" + --count)
            }
        }


        var isShow = true
        var scrollRange = -1
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1){
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0){
                collapsingToolbar.title = "Jan Sflanaganvik sofa"
                isShow = true
                iv_backArrowWhite.isVisible=true
            } else if (isShow){
                iv_backArrowWhite.isVisible=false
                collapsingToolbar.title = " " //careful there should a space between double quote otherwise it wont work
                isShow = false
            }
        })







    }
}