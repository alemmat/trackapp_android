package com.example.trackapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.test.ApiService

class RegisterActivity : MasterActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initActivity()
        
        val btnRegister = findViewById(R.id.btnRegister) as Button

        btnRegister.setOnClickListener {

            val inputName = findViewById<EditText>(R.id.inputName)
            val inputEmail = findViewById<EditText>(R.id.inputEmail)
            val inputPassword = findViewById<EditText>(R.id.inputPassword)
            val inputPasswordConfirm = findViewById<EditText>(R.id.inputPasswordConfirm)

            val password = inputPassword.text.toString()
            val passwordConfirm = inputPasswordConfirm.text.toString()

            if ( password.equals(passwordConfirm) ){

                val register = Register( inputName.text.toString(), inputEmail.text.toString(), password, passwordConfirm)

                this.registerUser(register)

                val intent = Intent(applicationContext, TrackActivity::class.java)
                startActivity(intent)
                finish()

            }else{

                Toast.makeText(this@RegisterActivity,"Password mismatch", Toast.LENGTH_SHORT).show()
            }
        }
    }
}