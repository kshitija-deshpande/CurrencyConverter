package com.kotlin.illusiontoreality.currencyconverter

import com.kotlin.illusiontoreality.currencyconverter.controller.CurrencyConverterController
import org.junit.Assert
import org.junit.Test

class CurrencyConverterControlerUnitTest {

    private val currencyList = CurrencyConverterController.getMap()

    init {
        CurrencyConverterController.addDefaultCurrencies()
    }

    @Test
    fun checkIfUSDCurrencyThere_isCorrect() {
        Assert.assertEquals(currencyList?.containsKey("USD"), true)
    }

    @Test
    fun checkIfABCCurrencyThere_isNotCorrect() {
        Assert.assertEquals(currencyList?.containsKey("ABC"), false)
    }

    @Test
    fun checkIfUSDValue1_isCorrect() {
        Assert.assertEquals(currencyList?.get("USD")!!, 1.0, 0.2)
    }

    @Test
    fun checkIfUSDToINRValue1_isCorrect() {
        Assert.assertEquals(currencyList?.get("INR")!!, 73.80, 0.99)
    }

    @Test
    fun check168EntriesCurrency_isCorrect() {
        Assert.assertEquals(currencyList?.size, 168)
    }

    @Test
    fun convertUSDtoINRUsingMethod_isCorrect() {
        Assert.assertEquals(CurrencyConverterController.convertFromTo("USD", "INR", 10.0)!!, 738.0, 2.0)
    }
}