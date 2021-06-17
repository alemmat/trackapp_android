package com.example.trackapp

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

    private val locationPermissionCode = 2
    private val TAG = "MyActivity"

    lateinit var service: ApiService

    private fun getTrack(){

        service.getTrack("Bearer 1|sYQzuXVG9qYiCqM025sqXzpOIb9GsZqktLVxDufE").enqueue(object: Callback<Track>{
            override fun onResponse(call: Call<Track>?, response: Response<Track>?) {
                val track = response?.body()

                Log.i("get retrofit", Gson().toJson(track))
            }
            override fun onFailure(call: Call<Track>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        service = this.settingRetrofit()
    }
}