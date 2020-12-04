package com.ifpr.lubank.dao

import android.content.IntentSender
import com.ifpr.lubank.models.Record
import com.ifpr.lubank.network.services.RecordService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecordDAO {
    val url = "http://10.0.2.2:3000/"
    val retrofit = Retrofit.Builder()
        .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RecordService::class.java)

    fun getAll(finished: (records : List<Record >) -> Unit) {

        service.getAll().enqueue(object : Callback<List<Record>> {
            override fun onResponse(call: Call<List<Record>>, response: Response<List<Record>>) {
                val records = response.body()!!
                finished(records)
            }

            override fun onFailure(call: Call<List<Record>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}