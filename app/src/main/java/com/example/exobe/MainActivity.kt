package com.example.exobe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FragmentDescription(), "Description")
        adapter.addFragment(FragmentMaterials(), "Materials")
        adapter.addFragment(FragmentReviews(), "Reviews")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
    }
}
