package com.csstalker.aaa3.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

object AAA3 {

    fun sayMyName(): String {
        val obj = Name("Heisenberg")
        return Gson().toJson(obj)
    }

}

data class Name(
    @SerializedName("nickname")
    val nickname: String
)