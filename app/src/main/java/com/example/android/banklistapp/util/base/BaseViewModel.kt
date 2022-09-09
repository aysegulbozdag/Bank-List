package com.example.android.banklistapp.util.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(override val coroutineContext: CoroutineContext) : ViewModel(), CoroutineScope {
    private val coroutinesScope = CoroutineScope(Dispatchers.Default + Job())
    val errorMessage: MutableLiveData<String> = MutableLiveData()


    override fun onCleared() {
        super.onCleared()
        coroutinesScope.cancel()
    }
}