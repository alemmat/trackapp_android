package com.example.trackapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : MasterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}