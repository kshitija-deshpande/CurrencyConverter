package com.kotlin.illusiontoreality.currencyconverter

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val usdToInr = 73.0

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun convertFromTwoUSDToINR_isCorrect() {
        assertEquals(146.0, usdToInr * 2, 0.2)
    }
}