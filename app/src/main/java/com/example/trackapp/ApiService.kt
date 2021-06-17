package com.example.test

import com.example.trackapp.Login
import com.example.trackapp.Register
import com.example.trackapp.Token
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @POST("api/position/")
    fun postPosition(@Header("Authorization") token: String, @Body position: Position?): Call<Position>

    @GET("api/track/")
    fun getTrack(@Header("Authorization") token: String): Call<Track>

    @POST("api/register/")
    fun register(@Body register: Register?): Call<Token>

    @POST("api/login/")
    fun login(@Body login: Login?): Call<Token>
}