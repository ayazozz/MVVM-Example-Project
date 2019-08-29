package com.example.currencyapp.currencyDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CurrencyDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("Main thread")
    private var viewModelJob  = Job()
    lateinit var viewModel: CurrencyDetailsViewModel
    lateinit var baseStr :String


    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = CurrencyDetailsViewModel()
        baseStr = "EUR"
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun getDetails() = runBlocking(Dispatchers.Main+viewModelJob){

       val result =  viewModel.getDetails(baseStr)
        assertNotNull(result)
        assertEquals("CAD",result.value!!.rates.keys.elementAt(0))
    }
}