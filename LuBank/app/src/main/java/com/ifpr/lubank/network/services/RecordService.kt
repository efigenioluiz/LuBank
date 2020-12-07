package com.ifpr.lubank.network.services

import com.ifpr.lubank.models.Record
import com.ifpr.lubank.models.User
import retrofit2.Call
import retrofit2.http.*

interface RecordService {


    @GET("records?")
    fun getAll(@Query("fk_user") fk_user: Long): Call<List<Record>>


    @GET("/records/{fk_user}&{person}")
    fun getRecord(@Path("fk_user") fk_user: Long, @Path("person") person : String): Call<List<Record>>

    @POST("records")
    @Headers("Content-Type: application/json")
    fun insert(@Body record: Record): Call<Record>

    @PATCH("records/{id}")
    @Headers("Content-Type: application/json")
    fun update(@Path("id") id: Long, @Body user: Record): Call<Record>

    @DELETE("records/{id}")
    fun delete(@Path("id") id: Long): Call<Void>


//
//    @Query("SELECT * FROM records WHERE (records.fk_user = :id)")
//    fun getRecordsByUser(id: Long?): List<Record>
//
//    @Query("SELECT SUM (value) FROM records where (records.fk_user = :id)")
//    fun getSumBalance(id: Long): Long
//
//    @Query("SELECT SUM (value) FROM records where (records.fk_user = :id) AND  (records.kind = 0)")
//    fun getSumExpenses(id: Long): Long
//
//    @Query("SELECT SUM (value) FROM records where (records.fk_user = :id) AND (records.kind = 1)")
//    fun getSumRevenue(id: Long): Long
//
//
//    @Query("SELECT *FROM records WHERE ( records.fk_user = :id ) and   (records.person LIKE :latter or   records.person LIKE :initialLatter ) ")
//    fun getRecordsByPerson(latter: String, initialLatter: String, id: Long?): List<Record>
}