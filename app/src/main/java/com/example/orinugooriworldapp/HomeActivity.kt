package com.example.orinugooriworldapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userIDData = intent.getStringExtra("UserID")

        Log.d("HomeActivity", "Received User ID: $userIDData")

        var tvDisplayID = findViewById<TextView>(R.id.tv_id_display)

        tvDisplayID.text = userIDData

        val btnFinish = findViewById<Button>(R.id.btn_finish)

        btnFinish.setOnClickListener {
            finish()
        }


    }
}