package com.example.currencyapp.currencyList

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyapp.data.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CurrencyListViewModel : ViewModel(), Observable {


    private var viewModelJob  = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

   @Bindable
    val getSearchValue = MutableLiveData<String>()

    private var _currencyRatesList = MutableLiveData<List<String>> ()
    val currencyRatesList: LiveData<List<String>> get() = _currencyRatesList

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _isCreatedFragmentFirst = MutableLiveData<Boolean>()
    val isCreatedFragmentFirst: LiveData<Boolean> get() = _isCreatedFragmentFirst

    init {
        getList()
        _isCreatedFragmentFirst.value = true

    }

    fun getList() {

        uiScope.launch {
            val lastCurrencyRates = ApiService.ApiServiceObject.retrofitService.getLatestCurrencyRates()

            try {

                val list = lastCurrencyRates.await().rates.keys.toMutableSet();
                list.add("EUR");
                _currencyRatesList.value =  list.sorted();


            }catch (t:Throwable)
            {
                _errorMessage.value = t.message

            }
        }


    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
