package com.example.android.banklistapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.banklistapp.Result
import com.example.android.banklistapp.model.Bank
import com.example.android.banklistapp.model.BankListResponse
import com.example.android.banklistapp.network.BankService
import com.example.android.banklistapp.repository.BankListRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import com.example.android.banklistapp.network.State as State

class BankListViewModel : ViewModel() {
    private val repository: BankListRepo = BankListRepo(BankService.bankApi)
    private val _bankList = MutableLiveData<Result<List<Bank>>>()
    val bankList = _bankList

    init {
        getBankList()
    }

     private fun getBankList() {
      viewModelScope.launch {
          repository.getBankList().collect{
              bankList.value = it
          }
      }

    }

}