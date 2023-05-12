package com.example.exobe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.forgot_pass.*
import kotlinx.android.synthetic.main.user_login.*

class ForgotPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_pass)

        val maxPhoneLength = 10
        et_phone2.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))
        /*Toast.makeText(this, "Phone number max length is 10 characters", Toast.LENGTH_SHORT).show()*/

        supportActionBar?.hide()

        iv_arrow_back2.setOnClickListener {

            finish()
        }
        et_phone2.doOnTextChanged { text, start, before, count ->
            validatePhone()
        }

        btn_submit2.setOnClickListener {
            validations()
        }
    }
var flagGo2=0
    private fun validatePhone() {
        if (et_phone2.text.isEmpty()){
            ll_phone2.setBackgroundResource(R.drawable.et_bg_red)
            val_phone2.isVisible = true
            val_phone2.text = "*Please enter valid phone number."
        }
        else if (et_phone2.text.length<10){
            ll_phone2.setBackgroundResource(R.drawable.et_bg_red)
            val_phone2.isVisible = true
            val_phone2.text = "*Please enter 10 digits phone number"
        }
        else
        {
            ll_phone2.setBackgroundResource(R.drawable.et_bg)
            val_phone2.isVisible = false
            flagGo2++
        }
    }

    public fun validations(){
        flagGo2=0
        validatePhone()
        if (flagGo2==1)
        {
           // Toast.makeText(this, "OTP Generated", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@ForgotPass,OTP_Verification::class.java)
            intent.putExtra("phoneNumber",et_phone2.text.toString())
            intent.putExtra("page","forgotToOTP")
            startActivity(intent)
        }
    }
}