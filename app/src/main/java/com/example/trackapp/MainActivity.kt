package com.example.trackapp

import android.content.Intent
import android.location.LocationListener
import android.os.Bundle
import android.widget.Button

class MainActivity : MasterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActivity()
        checkUser()

        val btnRegister = findViewById(R.id.btnRegister) as Button

        btnRegister.setOnClickListener {

            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btnLogin = findViewById(R.id.btnLogin) as Button

        btnLogin.setOnClickListener {

            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}