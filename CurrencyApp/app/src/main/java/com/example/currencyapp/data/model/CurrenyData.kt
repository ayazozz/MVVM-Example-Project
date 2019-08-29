package com.example.currencyapp.data.model


import com.google.gson.annotations.SerializedName

data class CurrenyData(
    @SerializedName("rates") val rates:  HashMap<String, Double>,
    @SerializedName("base") val base: String,
    @SerializedName("date") val date: String
)