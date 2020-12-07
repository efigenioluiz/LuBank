package com.ifpr.lubank.dao

import com.ifpr.lubank.models.Record
import com.ifpr.lubank.network.services.RecordService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecordDAO {
    val url = "http://192.168.0.108:3000/"
    val retrofit = Retrofit.Builder()
        .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RecordService::class.java)


    fun getAll(fk_user : Long,finished: (records : List<Record >) -> Unit) {

        service.getAll(fk_user).enqueue(object : Callback<List<Record>> {
            override fun onResponse(call: Call<List<Record>>, response: Response<List<Record>>) {
                val records = response.body()!!
                finished(records)
            }

            override fun onFailure(call: Call<List<Record>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

    fun insert(record: Record, finished: (person: Record) -> Unit) {
        service.insert(record ).enqueue(object : Callback<Record> {
            override fun onResponse(call: Call<Record>, response: Response<Record>) {
                val record = response.body()!!
                finished(record)
            }
            override fun onFailure(call: Call<Record>, t: Throwable) { }
        })
    }
    fun update(record: Record, finished: ( Record) -> Unit) {
        service.update(record.id!!, record).enqueue(object : Callback<Record> {
            override fun onResponse(call: Call<Record>, response: Response<Record>) {
                val record = response.body()!!
                finished(record)
            }
            override fun onFailure(call: Call<Record>, t: Throwable) { }
        })
    }


    fun get(id: Long, person: String,finished: (List<Record>) -> Unit) {
        service.getRecord(id,person).enqueue(object : Callback<List<Record>> {
            override fun onResponse(call: Call<List<Record>>, response: Response<List<Record>>) {


                if(response.body()!!.isNotEmpty()) {
                    val records = response.body()!!
                    finished(records)
                }
            }

            override fun onFailure(call: Call<List<Record>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}