package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.exobe.databinding.UserLoginBinding
import kotlinx.android.synthetic.main.user_login.*

class UserLogin : AppCompatActivity()  {

//    lateinit var binding: UserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)

        supportActionBar?.hide()

        var f =true

        iv_visible0.setOnClickListener {
            if(f==true)
            {
                et_pass0.transformationMethod=HideReturnsTransformationMethod.getInstance()
                iv_visible0.setImageResource(R.drawable.eye_off)
                f=false
            }
            else
            {
                et_pass0.transformationMethod=PasswordTransformationMethod.getInstance()
                iv_visible0.setImageResource(R.drawable.eye)
                f=true
            }
        }

        val maxPhoneLength = 10
        et_phone0.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))

        val maxPassLength = 16
        et_pass0.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPassLength))

        tv_forgot.setOnClickListener {
            val intent = Intent(this@UserLogin,ForgotPass::class.java)
            startActivity(intent)
        }

        tv_register0.setOnClickListener {
            val intent = Intent(this@UserLogin,Registration::class.java)
            startActivity(intent)
        }


        et_phone0.doOnTextChanged { text, start, before, count ->

                validatePhone()

        }
        et_pass0.doOnTextChanged { text, start, before, count ->

        validatePassword()

        }

//        cb_rem.setOnClickListener {
//            agreement()
//        }


        btn_login.setOnClickListener {

            validations()
            
        }
    }

    var flagGo=0

    fun validatePhone()
    {
        if (et_phone0.text.toString().isEmpty())
        {
            ll_phone.setBackgroundResource(R.drawable.et_bg_red)
            val_phone0.isVisible = true
            val_phone0.text = "*Please enter phone number"
        }
        else if (et_phone0.text.toString().length<10)
        {ll_phone.setBackgroundResource(R.drawable.et_bg_red)
            val_phone0.isVisible = true
            val_phone0.text = "*Please enter 10 digit phone number"
        }
        else if (!et_phone0.text.matches(".*[0-9].*".toRegex()))
        {ll_phone.setBackgroundResource(R.drawable.et_bg_red)
            val_phone0.isVisible = true
            val_phone0.text = "*Please enter valid phone number"
        }
        else
        {ll_phone.setBackgroundResource(R.drawable.et_bg)
            val_phone0.isVisible = false
            flagGo++
        }
    }
    fun validatePassword()
    {
        if(et_pass0.text.isEmpty()) {
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Please enter valid password"

        }
        else if(et_pass0.text.length<8){
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Minimum 8 characters are allowed"

        }
        else if(!et_pass0.text.matches(".*[A-Z].*".toRegex())){
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one uppercase letter"
        }
        else if(!et_pass0.text.matches(".*[a-z].*".toRegex())){
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one lowercase letter"
        }
        else if(!et_pass0.text.matches(".*[0-9].*".toRegex())){
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one number"
        }
        else if(!et_pass0.text.matches(".*[&@#$%^+=_.*].*".toRegex())){
            ll_pass.setBackgroundResource(R.drawable.et_bg_red)
            val_pass0.isVisible = true
            val_pass0.text = "*Password must have atleast one special character"
        }
        else
        {ll_pass.setBackgroundResource(R.drawable.et_bg)
            val_pass0.isVisible = false
            flagGo++
        }
    }
    public fun validations()
    {flagGo=0
        validatePhone()
        validatePassword()
        //agreement()
        if (flagGo==2)
        {
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UserLogin,Home_Page::class.java)
            startActivity(intent)
            finish()
        }
    }
}