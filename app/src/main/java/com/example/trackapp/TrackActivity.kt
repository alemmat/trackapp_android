package com.example.trackapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.test.ApiService
import com.example.test.Track
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TrackActivity : MasterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        val btnTracking = findViewById(R.id.btnTracking) as Button

        btnTracking.setOnClickListener {

            launchPositionForegroundService()

        }
    }

    private fun launchPositionForegroundService(){
        Intent(this, PositionForegroundService::class.java).also {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                startForegroundService(it)
                return
            }

            startService(it)
        }
    }
}