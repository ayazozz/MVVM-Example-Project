package com.example.currencyapp.currencyDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyapp.data.model.CurrenyData
import com.example.currencyapp.data.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CurrencyDetailsViewModel (): ViewModel() {

    private var viewModelJob  = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _currencyRatesList = MutableLiveData<CurrenyData> ()
    val currencyRatesList: LiveData<CurrenyData>?
        get() = _currencyRatesList

    val _tabValue = MutableLiveData<String>()
    val tabValue :LiveData<String> get() = _tabValue

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    fun getDetails(base : String) : LiveData<CurrenyData>{

        _tabValue.value = base

        uiScope.launch {
            val currencyRateDetails = ApiService.ApiServiceObject.retrofitService.getCurrencyDetails(base)
            try {
                _currencyRatesList.value = currencyRateDetails.await()

            }catch (t:Throwable)
            {
                _errorMessage.value = t.message


            }
        }


          return currencyRatesList!!
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}