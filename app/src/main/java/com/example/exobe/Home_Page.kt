package com.example.exobe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_page.*

class Home_Page : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)


        var goToFrag = intent.getStringExtra("goToFragment").toString()
        var goToPopular = intent.getStringExtra("goToPopular").toString()
        var goToServices = intent.getStringExtra("goToServices").toString()

        val homeFragment = HomeFragment()
        val servicesFragment = ServicesFragment()
        val categoryFragment = CategoryFragment()
        val wishlistFragment = WishlistFragment()
        val profileFragment = ProfileFragment()

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_services -> replaceFragment(servicesFragment)
                R.id.nav_category -> replaceFragment(categoryFragment)
                R.id.nav_wishlist -> replaceFragment(wishlistFragment)
                R.id.nav_profile -> replaceFragment(profileFragment)
            }
            true
        }


        if (goToFrag=="homeToCategory")
        {//replaceFragment2(homeFragment)
            replaceFragment2(categoryFragment)
            bottomNav.setSelectedItemId(R.id.nav_category)
        }

        else if(goToPopular=="homeToPopular")
        {
            replaceFragment2(categoryFragment)
            bottomNav.setSelectedItemId(R.id.nav_category)
        }
        else if(goToServices=="homeToServices")
        {
            replaceFragment2(servicesFragment)
            bottomNav.setSelectedItemId(R.id.nav_services)
        }

        else {
            replaceFragment(homeFragment)
        }

    }
    override fun onBackPressed() {
        var count = supportFragmentManager.backStackEntryCount


        if (count == 1) {
            super.onBackPressed()
            super.onBackPressed()
            //additional code
        } else {

            bottomNav.setSelectedItemId(R.id.nav_home)
            for (i in 1..count)
            {
                supportFragmentManager.popBackStack()
            }

            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()

        }

    }




    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.home_frame,fragment).addToBackStack("n2n")
            transaction.commit()
        }

    }
    private fun replaceFragment2(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.home_frame,fragment)
            transaction.commit()
        }

    }
}