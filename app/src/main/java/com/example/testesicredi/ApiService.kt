package com.example.testesicredi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/events")
    fun getEvents() :Call<MutableList<EventModel>>

}