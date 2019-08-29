package com.example.currencyapp.data.model


import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("CAD")
    val cAD: Double,
    @SerializedName("HKD")
    val hKD: Double,
    @SerializedName("ISK")
    val iSK: Double,
    @SerializedName("PHP")
    val pHP: Double,
    @SerializedName("DKK")
    val dKK: Double,
    @SerializedName("HUF")
    val hUF: Double,
    @SerializedName("CZK")
    val cZK: Double,
    @SerializedName("AUD")
    val aUD: Double,
    @SerializedName("RON")
    val rON: Double,
    @SerializedName("SEK")
    val sEK: Double,
    @SerializedName("IDR")
    val iDR: Double,
    @SerializedName("INR")
    val iNR: Double,
    @SerializedName("BRL")
    val bRL: Double,
    @SerializedName("RUB")
    val rUB: Double,
    @SerializedName("HRK")
    val hRK: Double,
    @SerializedName("JPY")
    val jPY: Double,
    @SerializedName("THB")
    val tHB: Double,
    @SerializedName("CHF")
    val cHF: Double,
    @SerializedName("SGD")
    val sGD: Double,
    @SerializedName("PLN")
    val pLN: Double,
    @SerializedName("BGN")
    val bGN: Double,
    @SerializedName("TRY")
    val tRY: Double,
    @SerializedName("CNY")
    val cNY: Double,
    @SerializedName("NOK")
    val nOK: Double,
    @SerializedName("NZD")
    val nZD: Double,
    @SerializedName("ZAR")
    val zAR: Double,
    @SerializedName("USD")
    val uSD: Double,
    @SerializedName("MXN")
    val mXN: Double,
    @SerializedName("ILS")
    val iLS: Double,
    @SerializedName("GBP")
    val gBP: Double,
    @SerializedName("KRW")
    val kRW: Double,
    @SerializedName("MYR")
    val mYR: Double,
    @SerializedName("EUR")
    val eUR: Double
)