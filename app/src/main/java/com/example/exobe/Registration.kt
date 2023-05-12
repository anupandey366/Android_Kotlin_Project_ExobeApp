package com.example.exobe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.user_login.*

class Registration : AppCompatActivity()  {

    lateinit var window : PopupWindow

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val view =layoutInflater.inflate(R.layout.popup_terms,null)
        window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        var f =true
        iv_visible1.setOnClickListener {
            if(f==true)
            {
                et_pass1.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_visible1.setImageResource(R.drawable.eye_off)
                f=false
            }
            else
            {
                et_pass1.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_visible1.setImageResource(R.drawable.eye)
                f=true
            }
        }
        var f2 =true
        iv_convisible1.setOnClickListener {
            if(f2==true)
            {
                et_conpass1.transformationMethod= HideReturnsTransformationMethod.getInstance()
                iv_convisible1.setImageResource(R.drawable.eye_off)
                f2=false
            }
            else
            {
                et_conpass1.transformationMethod= PasswordTransformationMethod.getInstance()
                iv_convisible1.setImageResource(R.drawable.eye)
                f2=true
            }
        }


        val maxFirstNLength = 12
        et_firstn.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxFirstNLength))
        val maxLastNLength = 12
        et_lastn.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLastNLength))
        val maxPhoneLength = 10
        et_phone1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPhoneLength))
        val maxEmailLength = 36
        et_email1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))
        val maxPassLength = 16
        et_pass1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPassLength))

        val maxConPassLength = 16
        et_conpass1.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxConPassLength))


        tv_terms.setOnClickListener {


            val view =layoutInflater.inflate(R.layout.popup_terms,null)
            window = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)


            val iv_crossBtn=view.findViewById<ImageView>(R.id.iv_crossBtn)
            iv_crossBtn.setOnClickListener {

                window.dismiss()
            }

            window.contentView= view

            window.showAsDropDown(tv_terms)
        }



        tv_already.setOnClickListener {
            finish()
        }
////////////////////////////////////////////////////////

        et_firstn.doOnTextChanged { text, start, before, count ->
                validateFirstName()
        }
        et_lastn.doOnTextChanged { text, start, before, count ->
                validateLastName()
        }
        et_phone1.doOnTextChanged { text, start, before, count ->
                validatePhone()
        }
        et_email1.doOnTextChanged { text, start, before, count ->
                validateEmail()
        }
        et_pass1.doOnTextChanged { text, start, before, count ->
                validatePassword()
        }
        et_conpass1.doOnTextChanged { text, start, before, count ->
                validateConfirmPassword()
        }

 ///////////////////////////////////////////////////////

        et_firstn.setOnFocusChangeListener { view, hasFocused ->
            if (!hasFocused)
            {if (!et_firstn.text.toString().isEmpty() && et_firstn.text[0].isLowerCase())
            {
                et_firstn.setText(et_firstn.text.toString().lowercase().capitalize())
            }
            }
        }

        et_lastn.setOnFocusChangeListener { view, hasFocused ->
            if (!hasFocused)
            {if (!et_lastn.text.toString().isEmpty() && et_lastn.text[0].isLowerCase())
            {
                et_lastn.setText(et_lastn.text.toString().lowercase().capitalize())
            }
            }
        }

        //////////////////////////////////////////////////////////////

        cb_terms.setOnClickListener {
            agreement()
        }

        btn_register.setOnClickListener {
            validateRegistration()
        }
    }
/////////////////////////////////////////////////////////

    private fun agreement() {
        if (!cb_terms.isChecked)
        {
            val_checkBox1.isVisible=true
            val_checkBox1.text="*Accept terms and conditions"
        }
        else
        {
            val_checkBox1.isVisible=false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////

    private fun validateEmail() {
        if (et_email1.text.isEmpty()) {
            et_email1.setBackgroundResource(R.drawable.et_bg_red)
            val_email1.isVisible = true
            val_email1.text = "*Please enter E-mail "
        }
        else if(!et_email1.text.matches(".*^[a-z0-9]+([.]{1}|[a-z0-9])+[@]{1}[a-z]+(.com|.in){1}$.*".toRegex())){
            et_email1.setBackgroundResource(R.drawable.et_bg_red)
            val_email1.isVisible = true
            val_email1.text = "*Please enter valid email"
        }
        else
        {
            et_email1.setBackgroundResource(R.drawable.et_bg)
            val_email1.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////


    private fun validateLastName() {
        if (et_lastn.text.isEmpty()) {
            et_lastn.setBackgroundResource(R.drawable.et_bg_red)
            val_lastn.isVisible = true
            val_lastn.text = "*Please enter Last Name"
        }
        else if(!et_lastn.text.matches(".*^[A-Z]{1}.*".toRegex())){
            et_lastn.setBackgroundResource(R.drawable.et_bg_red)
            val_lastn.isVisible = true
            val_lastn.text = "*First letter must be in uppercase"
        }
        else if(et_lastn.text.length<3){
            et_lastn.setBackgroundResource(R.drawable.et_bg_red)
            val_lastn.isVisible = true
            val_lastn.text = "*Minimum 3 characters are allowed"
        }
        else
        {
            et_lastn.setBackgroundResource(R.drawable.et_bg)
            val_lastn.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////

    private fun validateFirstName() {
        if (et_firstn.text.isEmpty()) {
            et_firstn.setBackgroundResource(R.drawable.et_bg_red)
            val_firstn.isVisible = true
            val_firstn.text = "*Please enter First Name"
        }


        else if(!et_firstn.text.matches(".*^[A-Z]{1}.*".toRegex())){
            et_firstn.setBackgroundResource(R.drawable.et_bg_red)
            val_firstn.isVisible = true
            val_firstn.text = "*First letter must be in uppercase"
        }
        else if(et_firstn.text.length<3){
            et_firstn.setBackgroundResource(R.drawable.et_bg_red)
            val_firstn.isVisible = true
            val_firstn.text = "*Minimum 3 characters are allowed"

        }
        else
        {
            et_firstn.setBackgroundResource(R.drawable.et_bg)
            val_firstn.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////


    private fun validateConfirmPassword() {
        if (et_conpass1.text.isEmpty()) {
            ll_conpass1.setBackgroundResource(R.drawable.et_bg_red)
            val_conpass1.isVisible = true
            val_conpass1.text = "*Please enter confirm password."
        }

        else if (et_conpass1.text.toString()!=et_pass1.text.toString()){
            ll_conpass1.setBackgroundResource(R.drawable.et_bg_red)
            val_conpass1.isVisible = true
            val_conpass1.text = "*Password does not matched"
        }

        else if (!cb_terms.isChecked()) {
            ll_conpass1.setBackgroundResource(R.drawable.et_bg_red)
            val_checkBox1.isVisible = true
            val_checkBox1.text = "*Please accept terms and conditions. "
        }
        else
        {
            ll_conpass1.setBackgroundResource(R.drawable.et_bg)
            val_conpass1.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////


    private fun validatePassword() {
        if (et_pass1.text.isEmpty()) {
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Please enter Password"
        }

        else if(et_pass1.text.length<8){
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Minimum 8 characters are allowed"

        }
        else if(!et_pass1.text.matches(".*[A-Z].*".toRegex())){
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one uppercase letter"
        }
        else if(!et_pass1.text.matches(".*[a-z].*".toRegex())){
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one lowercase letter"
        }
        else if(!et_pass1.text.matches(".*[0-9].*".toRegex())){
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one number"
        }
        else if(!et_pass1.text.matches(".*[&@#$%^+=_.*].*".toRegex())){
            ll_pass1.setBackgroundResource(R.drawable.et_bg_red)
            val_pass1.isVisible = true
            val_pass1.text = "*Password must have atleast one special character"
        }
        else
        {
            ll_pass1.setBackgroundResource(R.drawable.et_bg)
            val_pass1.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////


    var flagGo1=0
    private fun validatePhone() {
        if (et_phone1.text.toString().isEmpty())
        {
            ll_phone1.setBackgroundResource(R.drawable.et_bg_red)
            val_phone1.isVisible = true
            val_phone1.text = "*Please enter phone number"
        }
        else if (et_phone1.text.toString().length<10)
        {ll_phone1.setBackgroundResource(R.drawable.et_bg_red)
            val_phone1.isVisible = true
            val_phone1.text = "*Please enter 10 digit phone number"
        }
        else if (!et_phone1.text.matches(".*[0-9].*".toRegex()))
        {ll_phone1.setBackgroundResource(R.drawable.et_bg_red)
            val_phone1.isVisible = true
            val_phone1.text = "*Please enter valid phone number"
        }
        else
        {
            ll_phone1.setBackgroundResource(R.drawable.et_bg)
            val_phone1.isVisible = false
            flagGo1++
        }
    }

    ////////////////////////////////////////////////////////////

    fun validateRegistration()
    {
        flagGo1=0
        validateFirstName()
        validateLastName()
        validatePhone()
        validatePassword()
        validateConfirmPassword()
        validateEmail()
        agreement()
            if(flagGo1==7){

                val intent = Intent(this@Registration, OTP_Verification::class.java)

                intent.putExtra("phoneNumber",et_phone1.text.toString())
                intent.putExtra("page","registrationToOTP")
                startActivity(intent)
            }
        }

    override fun onBackPressed() {
        if(window.isShowing()) {
            window.dismiss();
            return;
        }
        super.onBackPressed();

    }

}
