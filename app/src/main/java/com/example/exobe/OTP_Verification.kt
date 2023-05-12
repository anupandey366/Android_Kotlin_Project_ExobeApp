package com.example.exobe

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.otp_verification.*

class OTP_Verification : AppCompatActivity() {

    private val CHANNEL_ID= "cahnnel_id_example_01"
    private val notificationId= 101
    var OTP="2000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_verification)



//        var newOTP: OTP_Verification= OTP_Verification()  //tv_wrongOTP


        tv_comment1.text="Please enter the 4-digit verification code that was sent to "+intent.getStringExtra("phoneNumber")+". The code is valid for 30 minutes."

        var pageInfo=intent.getStringExtra("page")
        /*validate_MobileNumber.isVisible = true

        "Please enter the 4-digit verification code that was sent to 9936595085. The code is valid for 30 minutes."

        validate_MobileNumber.text = "*Please enter valid phone number"*/

        tv_resendOTP.isEnabled=false
        tv_resendOTP.setTextColor(Color.parseColor("#bf1e2e"));
        resendOTP()

        tv_resendOTP.setOnClickListener {
            tv_resendOTP.isEnabled=false
            tv_resendOTP.setTextColor(Color.parseColor("#bf1e2e"));
            Toast.makeText(this, "OTP has been resent", Toast.LENGTH_SHORT).show()
            resendOTP()
        }

        iv_arrow_back4.setOnClickListener {
            finish()
        }


        et_1.addTextChangedListener(GenericTextWatcher(et_1, et_2))
        et_2.addTextChangedListener(GenericTextWatcher(et_2, et_3))
        et_3.addTextChangedListener(GenericTextWatcher(et_3, et_4))
        et_4.addTextChangedListener(GenericTextWatcher(et_4, null))



        et_1.setOnKeyListener(GenericKeyEvent(et_1, null))
        et_2.setOnKeyListener(GenericKeyEvent(et_2, et_1))
        et_3.setOnKeyListener(GenericKeyEvent(et_3, et_2))
        et_4.setOnKeyListener(GenericKeyEvent(et_4, et_3))


        et_1.doOnTextChanged { text, start, before, count ->
            if (et_1.text.isEmpty())
            { et_1.setBackgroundResource(R.drawable.otp_red_box) }
            else
            { et_1.setBackgroundResource(R.drawable.otp_edittext_background)}
            tv_wrongOTP.isVisible=false
        }

        et_2.doOnTextChanged { text, start, before, count ->
            if (et_2.text.isEmpty())
            { et_2.setBackgroundResource(R.drawable.otp_red_box) }
            else
            { et_2.setBackgroundResource(R.drawable.otp_edittext_background)}
            tv_wrongOTP.isVisible=false
        }

        et_3.doOnTextChanged { text, start, before, count ->
            if (et_3.text.isEmpty())
            { et_3.setBackgroundResource(R.drawable.otp_red_box) }
            else
            { et_3.setBackgroundResource(R.drawable.otp_edittext_background)}
            tv_wrongOTP.isVisible=false
        }

        et_4.doOnTextChanged { text, start, before, count ->
            if (et_4.text.isEmpty())
            { et_4.setBackgroundResource(R.drawable.otp_red_box) }
            else
            { et_4.setBackgroundResource(R.drawable.otp_edittext_background)}
            tv_wrongOTP.isVisible=false
        }

        /*et_1.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                if (et_1.text.isEmpty())
                { et_1.setBackgroundResource(R.drawable.otp_red_box) }
                else
                { et_1.setBackgroundResource(R.drawable.otp_edittext_background)}
                tv_wrongOTP.isVisible=false
            }

        }
        et_2.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                if (et_2.text.isEmpty())
                { et_2.setBackgroundResource(R.drawable.otp_red_box) }
                else
                { et_2.setBackgroundResource(R.drawable.otp_edittext_background)}
                tv_wrongOTP.isVisible=false
            }

        }
        et_3.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                if (et_3.text.isEmpty())
                { et_3.setBackgroundResource(R.drawable.otp_red_box) }
                else
                { et_3.setBackgroundResource(R.drawable.otp_edittext_background)}
                tv_wrongOTP.isVisible=false
            }

        }
        et_4.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                if (et_4.text.isEmpty())
                { et_4.setBackgroundResource(R.drawable.otp_red_box) }
                else
                { et_4.setBackgroundResource(R.drawable.otp_edittext_background)}
                tv_wrongOTP.isVisible=false
            }

        }*/

        btn_submit4.setOnClickListener {
            val getOTP=et_1.text.toString()+et_2.text.toString()+et_3.text.toString()+et_4.text.toString()
            /*if (et_1.text.isEmpty())
            {
                et_1.setBackgroundResource(R.drawable.otp_red_box)

            }
            if (et_2.text.isEmpty())
            {
                et_2.setBackgroundResource(R.drawable.otp_red_box)
            }
            if (et_3.text.isEmpty())
            {
                et_3.setBackgroundResource(R.drawable.otp_red_box)
            }
            if (et_4.text.isEmpty())
            {
                et_4.setBackgroundResource(R.drawable.otp_red_box)
            }*/
            if(OTP!=getOTP)
            {   et_1.setBackgroundResource(R.drawable.otp_red_box)
                et_2.setBackgroundResource(R.drawable.otp_red_box)
                et_3.setBackgroundResource(R.drawable.otp_red_box)
                et_4.setBackgroundResource(R.drawable.otp_red_box)
                tv_wrongOTP.isVisible=true
                Toast.makeText(this, "Incorrect OTP", Toast.LENGTH_SHORT).show()

            }
            if(!et_1.text.isEmpty()&&!et_2.text.isEmpty()&&!et_3.text.isEmpty()&&!et_4.text.isEmpty()&&OTP==getOTP)
            {   et_1.setBackgroundResource(R.drawable.otp_edittext_background)
                et_2.setBackgroundResource(R.drawable.otp_edittext_background)
                et_3.setBackgroundResource(R.drawable.otp_edittext_background)
                et_4.setBackgroundResource(R.drawable.otp_edittext_background)
                tv_wrongOTP.isVisible=false

                if (pageInfo=="registrationToOTP")
                {Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    val intent2= Intent(this@OTP_Verification,UserLogin::class.java)
                    intent2.flags= Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent2)
                }
                if (pageInfo=="forgotToOTP")
                {
                    val intent2= Intent(this@OTP_Verification,ResetPass::class.java)
                    startActivity(intent2)
                }

                finish()
            }
        }

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {

            val name ="OTP"
            val descriptionText=OTP
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
                description=OTP
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification()
    {
        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.exobe)
            .setContentTitle("OTP")
            .setContentText("Your current OTP is: "+OTP)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }
    }


    fun resendOTP()
    {
        OTP=generateOTP()
        sendNotification()
        Toast.makeText(this, "Your OTP is "+OTP, Toast.LENGTH_SHORT).show()
        object : CountDownTimer(16000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {

                tv_timer.setText("00:"+"%02d".format(millisUntilFinished / 1000) )
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                tv_timer.setText("00:00")
                tv_resendOTP.isEnabled=true
                tv_resendOTP.setTextColor(Color.parseColor("#000000"));
            }
        }.start()
    }

    fun generateOTP() :String
    {
        val randomPin = (Math.random()*9000).toInt()+1000

        return randomPin.toString()
    }
}