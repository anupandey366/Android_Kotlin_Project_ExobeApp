package com.example.anu_exobenew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        Handler().postDelayed({
            val intent= Intent(this@Splash_Screen,User_Login::class.java)
            startActivity(intent)
            finish()

        },2000)
    }
}