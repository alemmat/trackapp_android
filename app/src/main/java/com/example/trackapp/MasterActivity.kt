package com.example.trackapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.test.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class MasterActivity: AppCompatActivity() {

    fun settingRetrofit(): ApiService {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.0.7/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create<ApiService>(ApiService::class.java)
    }
}