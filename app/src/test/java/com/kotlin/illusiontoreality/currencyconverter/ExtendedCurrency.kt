package com.kotlin.illusiontoreality.currencyconverter

import com.kotlin.illusiontoreality.currencyconverter.utils.AllCurencies
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class ExtendedCurrency {

    private lateinit var currecies: AllCurencies

    init {
        currecies = AllCurencies()
    }

    @Test
    fun checkIfFirstEntryIsUSD_isCorrect() {
        Assert.assertEquals(currecies.allCurrencies[0].code, "USD")
    }

    @Test
    fun checkIfSomeEntryIsINR_isCorrect() {
        Assert.assertEquals(currecies.allCurrencies[39].code, "INR")
    }

    @Test
    fun checkIfLastEntryIsZAR_isCorrect() {
        val lastIndex = currecies.allCurrencies.size - 1
        Assert.assertEquals(currecies.allCurrencies[lastIndex].code, "ZAR")
    }

    @Test
    fun checkIfFlagExist_isCorrect() {
        Assert.assertEquals(currecies.allCurrencies[39].flag != -1, true)
    }
}