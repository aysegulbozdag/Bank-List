package com.example.android.banklistapp.util.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.banklistapp.repository.BankListRepo
import com.example.android.banklistapp.viewmodel.BankListViewModel

class ViewModelFactory constructor(private val repository: BankListRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BankListViewModel::class.java)) {
            BankListViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}