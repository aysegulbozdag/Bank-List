package com.example.android.banklistapp.di

import com.example.android.banklistapp.network.BankApi
import com.example.android.banklistapp.network.BankService
import com.example.android.banklistapp.repository.BankListRepo
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.dsl.single


val appModule = module {
    single { BankService.bankApi }
}