package com.example.android.banklistapp.network

sealed class State<out R> {

    data class Success<out T>(val data: T) : State<T>()
    data class Error(val exception: Exception) : State<Nothing>()
    data class Loading<out T>(val data: T) : State<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading[data=$data]"
        }
    }
}
