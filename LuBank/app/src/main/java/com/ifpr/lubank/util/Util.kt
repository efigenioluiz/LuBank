package com.ifpr.lubank.util

import android.content.Context
import com.ifpr.lubank.dao.RecordDAO
import com.ifpr.lubank.models.User

object Util {
    lateinit var user:User
    val dao = RecordDAO()
}