package com.kotlin.illusiontoreality.currencyconverter.pojo

// Holder class for adapter data
class Currency {
    var code: String? = null
    var name: String? = null
    var symbol: String? = null
    var value: String? = null
    var resID: Int = 0

    constructor(code: String?, name: String?, symbol: String?, value: String?, resID: Int) {
        this.code = code
        this.name = name
        this.symbol = symbol
        this.value = value
        this.resID = resID
    }
}