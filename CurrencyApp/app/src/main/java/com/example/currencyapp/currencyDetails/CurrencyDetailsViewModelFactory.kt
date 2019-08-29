package com.example.currencyapp.currencyDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CurrencyDetailsViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyDetailsViewModel::class.java)) {
            return CurrencyDetailsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}