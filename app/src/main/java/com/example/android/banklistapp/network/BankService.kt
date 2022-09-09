package com.example.android.banklistapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BankService {
    private const val BASE_URL = "https://raw.githubusercontent.com/"

    val bankApi: BankApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(BankApi::class.java)
}