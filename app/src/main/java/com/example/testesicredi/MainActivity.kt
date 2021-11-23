package com.example.testesicredi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.mainView)

        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getEvents()

//        val button = findViewById<Button>(R.id.btnClick)
//        button.setOnClickListener{
        call.enqueue(object : Callback<MutableList<EventModel>> {
            override fun onResponse(call: Call<MutableList<EventModel>>, response: Response<MutableList<EventModel>>) {
                if(response.isSuccessful){
//                    Log.e("sucesso", response.body().toString())
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = EventAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<MutableList<EventModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("erro", t.message.toString())
            }
        })



    }

}


