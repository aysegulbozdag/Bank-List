package com.example.android.banklistapp.repository

import com.example.android.banklistapp.Result
import com.example.android.banklistapp.model.Bank
import com.example.android.banklistapp.model.BankListResponse
import com.example.android.banklistapp.network.BankApi
import com.example.android.banklistapp.network.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class BankListRepo(private val api: BankApi) {
    suspend fun getBankList() : Flow<Result<List<Bank>>> {
        return flow{
            emit(Result.loading())
            val character = api.getBankList()
            emit(Result.success(character))
        }.flowOn(Dispatchers.IO)
    }
}