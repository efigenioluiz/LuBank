package com.ifpr.lubank.models


import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*


data class Record(
    var person: String,
    var remarks: String = "",
    var value: Double,
    @SerializedName("fk_user") var fkUser: Long,
    var kind: Boolean,
    var registredAt: String = SimpleDateFormat("dd/MM/yyyy HH:mm").format(Date())

) {
    var id: Long? = null

    override fun equals(other: Any?) = other is Record && this.id == other.id
}






