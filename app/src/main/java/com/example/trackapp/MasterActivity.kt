package com.example.trackapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test.ApiService
import com.example.test.Track
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class MasterActivity: AppCompatActivity() {

    private val sharedPrefFile = "trackappsharedpreference"

    lateinit var sharedPreferences: SharedPreferences
    lateinit var service: ApiService

    fun initActivity(){
        sharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        service = this.settingRetrofit()
    }

    fun checkUser(){

        val sharedNameValue = sharedPreferences.getString("token","defaultname")

        if (sharedNameValue != null) {

            val intent = Intent(applicationContext, TrackActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun registerUser(register:Register){

        service.register(register).enqueue(object: Callback<Token>{
            override fun onResponse(call: Call<Token>?, response: Response<Token>?) {

                val token = response?.body()!!
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putString("token","Bearer " + token.token)
                editor.putString("user_name", token.user_name)
                editor.apply()
                editor.commit()

                Log.i("retrofit register", Gson().toJson(token))
            }
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun loginUser(login:Login){

        service.login(login).enqueue(object: Callback<Token>{
            override fun onResponse(call: Call<Token>?, response: Response<Token>?) {

                val token = response?.body()!!
                val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putString("token","Bearer " + token.token)
                editor.putString("user_name", token.user_name)
                editor.apply()
                editor.commit()

                Log.i("retrofit register", Gson().toJson(token))
            }
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

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

    fun settingRetrofit(): ApiService {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.0.7/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create<ApiService>(ApiService::class.java)
    }
}


