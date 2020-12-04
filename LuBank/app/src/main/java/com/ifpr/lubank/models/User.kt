package com.ifpr.lubank.models

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("username") var username: String,
    var password: String,
    var balance: Double = 0.0,
    var enabled: Boolean = true
) {
    var id: Long? = null

    override fun equals(other: Any?) = other is User && this.id == other.id


}

