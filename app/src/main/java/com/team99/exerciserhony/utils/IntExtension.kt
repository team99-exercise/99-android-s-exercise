package com.team99.exerciserhony.utils

fun Int.toUsdPerMonth(): String = "$${String.format("%,d", this)}/mo"

fun Int.toUsd(): String = "$${String.format("%,d", this)}"
