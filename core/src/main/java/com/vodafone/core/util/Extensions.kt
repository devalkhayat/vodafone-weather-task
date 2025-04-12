package com.vodafone.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun Long.toDayName():String{
    //val format = "dd MMM yyyy HH:mm:ss" // you can add the format you need
    val format = "EEEE" // you can add the format you need
    val sdf = SimpleDateFormat(format, Locale.getDefault()) // default local
    sdf.timeZone = TimeZone.getDefault() // set anytime zone you need
    return sdf.format(Date(this * 1000))
}
fun Long.toDate():String{
    val format = "dd MMM yyyy" // you can add the format you need
    val sdf = SimpleDateFormat(format, Locale.getDefault()) // default local
    sdf.timeZone = TimeZone.getDefault() // set anytime zone you need
    return sdf.format(Date(this * 1000))
}

fun String.toDegree():String{
    return "$this\u00B0"
}

fun String.toPercentage():String{
    return "$this %"
}
fun String.toKm():String{
    return "$this km/h"
}