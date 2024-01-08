package com.catnip.hotelier.utils

import java.text.NumberFormat
import java.text.NumberFormat.*
import java.util.Currency

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun Int.formatDecimalSeparator(): String {
    return toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}

fun Int.toCurrencyFormat(currencyCode : String = "USD"): String {
    val format: NumberFormat = getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance(currencyCode)
    return format.format(this)
}