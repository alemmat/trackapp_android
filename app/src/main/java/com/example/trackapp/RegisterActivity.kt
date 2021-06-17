package com.example.trackapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegisterActivity : MasterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}