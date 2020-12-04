package com.ifpr.lubank.dao

import android.util.Log
import com.ifpr.lubank.models.Record
import com.ifpr.lubank.models.User
import com.ifpr.lubank.network.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDAO {
    val url = "http://10.0.2.2:3000/"
    val retrofit = Retrofit.Builder()
        .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(UserService::class.java)

    fun getAll(finished: (users: List<User>) -> Unit) {

        service.getAll().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val users = response.body()!!

                finished(users)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

    fun login(usr: String, psw: String, finished: (users: User) -> Unit) {
        service.login(usr, psw).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()!!
                Log.i("hhh", user.username)
                Log.i("hhh", user.password)

                finished(user)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

    }

}