package com.example.orinugooriworldapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val btnSignUp = findViewById<Button>(R.id.btn_sign_up)
        val validation= IsEmptyInput()

        btnSignUp.setOnClickListener {
        if(validation.isEmptyInput(etvSignupID)||validation.isEmptyInput(etvSignUpName)||validation.isEmptyInput(etvSignUpPassword)){
            Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
        }else{
            finish()
        }

        }

    }
}