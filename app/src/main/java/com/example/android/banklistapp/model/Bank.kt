package com.example.android.banklistapp.model

import com.google.gson.annotations.SerializedName

data class Bank(
    val ID: Int,
    val dc_SEHIR: String,
    val dc_ILCE: String,
    val dc_BANKA_SUBE: String,
    val dc_BANK_KODU: String,
    val dc_ADRES: String
)
