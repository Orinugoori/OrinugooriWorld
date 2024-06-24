package com.example.orinugooriworldapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val etvSignUpName = findViewById<EditText>(R.id.etv_name)
        val etvSignupID = findViewById<EditText>(R.id.etv_id)
        val etvSignUpPassword = findViewById<EditText>(R.id.etv_password)

        val numpick = findViewById<NumberPicker>(R.id.numpick_age)

        numpick.minValue = 0
        numpick.maxValue = 100

        val etvSns = findViewById<EditText>(R.id.etv_sns)
        val btnSignUp = findViewById<ConstraintLayout>(R.id.btn_sign_up)




        val validation= IsEmptyInput()

        btnSignUp.setOnClickListener {

        if(validation.isEmptyInput(etvSignupID)||validation.isEmptyInput(etvSignUpName)||validation.isEmptyInput(etvSignUpPassword)||validation.isEmptyInput(etvSns)){
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
        }else{
            val userInfo = User(etvSignUpName.text.toString(),etvSignupID.text.toString(),etvSignUpPassword.text.toString(),numpick.value,etvSns.text.toString())

            val intent = Intent()
            intent.putExtra("userInfo" , userInfo)
            setResult(RESULT_OK,intent)
            finish()
        }

        }

    }
}