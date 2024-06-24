package com.example.orinugooriworldapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
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
import java.io.Serializable

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

        val userInfo = intent.getSerializableExtra("userInfo") as User

        val displayID = findViewById<TextView>(R.id.tv_id_display)
        val displayName = findViewById<TextView>(R.id.tv_user_name)
        val displayAge = findViewById<TextView>(R.id.tv_user_age)
        val displaySns = findViewById<TextView>(R.id.tv_user_instagram)

        displayID.text = userInfo.id
        displayName.text =userInfo.name
        displayAge.text = userInfo.age.toString()
        displaySns.text =userInfo.sns




        val btnFinish = findViewById<Button>(R.id.btn_finish)

        btnFinish.setOnClickListener {
            finish()
        }




    }

    private fun changeView(index : Int){

        val imageView = findViewById<ImageView>(R.id.iv_home_character)

        val imageList = listOf(R.drawable.iv_home_character_1,R.drawable.iv_home_character_2,R.drawable.iv_home_character_3,R.drawable.iv_home_character_4,R.drawable.iv_home_character_5)

        imageView.setImageResource(imageList[index])

    }
}