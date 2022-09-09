package com.example.android.banklistapp.network

import com.example.android.banklistapp.model.Bank
import com.example.android.banklistapp.model.BankListResponse
import retrofit2.http.GET

interface BankApi {
    @GET("fatiha380/mockjson/main/bankdata")
    suspend fun getBankList() : List<Bank>
}