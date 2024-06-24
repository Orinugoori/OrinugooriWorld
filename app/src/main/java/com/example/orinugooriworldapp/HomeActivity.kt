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
        val imageList = listOf(randomImage1,randomImage2,randomImage3,randomImage4,randomImage5)

        //index랑 일치하는 index를 가진 imageList만 Visible 나머지는 INVISIBLE로 설정


        for(i in imageList.indices){
            if(i == index){
                imageList[index].setTransitionVisibility(View.VISIBLE)
            }else{
             imageList[i].setTransitionVisibility(View.INVISIBLE)
            }
        }




    }
}