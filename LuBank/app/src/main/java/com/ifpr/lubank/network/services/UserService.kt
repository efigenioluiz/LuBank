package com.ifpr.lubank.network.services

import com.ifpr.lubank.models.User
import retrofit2.Call
import retrofit2.http.*


interface UserService {
    @GET("/users")
    fun getAll(): Call<List<User>>

    @GET("/users/{id}")
    fun getUser(@Path("id") id: Long): Call<User>


    @POST("users")
    @Headers("Content-Type: application/json")
    fun insert(@Body user: User): Call<User>

    @DELETE("users/{id}")
    fun delete(@Path("id") id: Long): Call<Void>

    @PATCH("users/{id}")
    @Headers("Content-Type: application/json")
    fun update(@Path("id") id: Long, @Body user: User): Call<User>


    @GET("users?")
    fun login(@Query("username") username: String, @Query("password") password: String): Call<User>

}
    //
//    @Query("SELECT * from users WHERE username = :username AND password = :password")
//    fun user(username: String, password: String): User
//
//
//    @Query("SELECT * from users WHERE users.id = :id ")
//    fun userById(id: Long?): User
//
//    @Query("SELECT * from users WHERE users.username LIKE :name ")
//    fun userByName(name: String): User


