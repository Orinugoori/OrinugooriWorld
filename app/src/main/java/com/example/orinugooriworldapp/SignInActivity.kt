package com.example.orinugooriworldapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var userInfo: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val etvID = findViewById<EditText>(R.id.etv_login_id)
        val etvPassword = findViewById<EditText>(R.id.etv_login_password)
        val btnLogin = findViewById<TextView>(R.id.btn_login)


        val btnSignUp = findViewById<TextView>(R.id.btn_sign_up)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    userInfo = result.data?.getParcelableExtra<User>("userInfo")

                    etvID.setText(userInfo?.id ?: "")
                    etvPassword.setText(userInfo?.password ?: "")

                }
            }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }


        btnLogin.setOnClickListener {
            if (isEmptyInput(etvID) || isEmptyInput(etvPassword)) {
                Toast.makeText(this, "아이디,비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userInfo", userInfo)
                startActivity(intent)

            }
        }


    }

    fun isEmptyInput(etv: EditText): Boolean {

        return if (etv.text.isEmpty()) {
            true
        } else {
            false
        }

    }


}





