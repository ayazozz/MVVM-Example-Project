package com.example.currencyapp.data.network

import com.example.currencyapp.data.model.CurrenyData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/latest")
    fun getLatestCurrencyRates():Deferred<CurrenyData>

    @GET("/latest")
    fun getCurrencyDetails(@Query("base") base: String):Deferred<CurrenyData>



    object ApiServiceObject{

        val retrofitService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }

    companion object {

        private val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.exchangeratesapi.io/")
            .build()


    }
}