package com.example.orinugooriworldapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

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


        val random = Random()
        val randomIndex = random.nextInt(5)

        changeView(randomIndex)



        val userIDData = intent.getStringExtra("UserID")

        Log.d("HomeActivity", "Received User ID: $userIDData")

        val tvDisplayID = findViewById<TextView>(R.id.tv_id_display)

        tvDisplayID.text = userIDData

        val btnFinish = findViewById<Button>(R.id.btn_finish)

        btnFinish.setOnClickListener {
            finish()
        }




    }

    private fun changeView(index : Int){
        val randomImage1 = findViewById<ImageView>(R.id.iv_home_character1)
        val randomImage2 = findViewById<ImageView>(R.id.iv_home_character2)
        val randomImage3 = findViewById<ImageView>(R.id.iv_home_character3)
        val randomImage4 = findViewById<ImageView>(R.id.iv_home_character4)
        val randomImage5 = findViewById<ImageView>(R.id.iv_home_character5)

        when (index){
            0 -> {
                randomImage1.setTransitionVisibility(View.VISIBLE)
                randomImage2.setTransitionVisibility(View.INVISIBLE)
                randomImage3.setTransitionVisibility(View.INVISIBLE)
                randomImage4.setTransitionVisibility(View.INVISIBLE)
                randomImage5.setTransitionVisibility(View.INVISIBLE)
            }
            1 -> {
                randomImage1.setTransitionVisibility(View.INVISIBLE)
                randomImage2.setTransitionVisibility(View.VISIBLE)
                randomImage3.setTransitionVisibility(View.INVISIBLE)
                randomImage4.setTransitionVisibility(View.INVISIBLE)
                randomImage5.setTransitionVisibility(View.INVISIBLE)
            }
            2 ->{
                randomImage1.setTransitionVisibility(View.INVISIBLE)
                randomImage2.setTransitionVisibility(View.INVISIBLE)
                randomImage3.setTransitionVisibility(View.VISIBLE)
                randomImage4.setTransitionVisibility(View.INVISIBLE)
                randomImage5.setTransitionVisibility(View.INVISIBLE)
            }
            3 -> {
                randomImage1.setTransitionVisibility(View.INVISIBLE)
                randomImage2.setTransitionVisibility(View.INVISIBLE)
                randomImage3.setTransitionVisibility(View.INVISIBLE)
                randomImage4.setTransitionVisibility(View.VISIBLE)
                randomImage5.setTransitionVisibility(View.INVISIBLE)
            }
            4 -> {
                randomImage1.setTransitionVisibility(View.INVISIBLE)
                randomImage2.setTransitionVisibility(View.INVISIBLE)
                randomImage3.setTransitionVisibility(View.INVISIBLE)
                randomImage4.setTransitionVisibility(View.INVISIBLE)
                randomImage5.setTransitionVisibility(View.VISIBLE)
            }
        }

    }
}