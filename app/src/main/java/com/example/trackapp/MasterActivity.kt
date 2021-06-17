package com.example.trackapp

import android.content.Intent
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


    fun registerUser(service: ApiService, register:Register):Token{

        var returnToken: Token? = Token("null","null")

        service.register(register).enqueue(object: Callback<Token>{
            override fun onResponse(call: Call<Token>?, response: Response<Token>?) {

                returnToken = response?.body()!!

                Log.i("retrofit register", Gson().toJson(returnToken))
            }
            override fun onFailure(call: Call<Token>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

        return returnToken!!
    }


    fun settingRetrofit(): ApiService {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.0.7/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create<ApiService>(ApiService::class.java)
    }
}