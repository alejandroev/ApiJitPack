package co.dito.abako.apijitpack.data.common.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String?.stringToTimeOld(): Long {
    return this?.replace("/", "")?.replace("Date(", "")?.replace(")", "")?.toLong() ?: 0
}

fun Date.dateTimeFormat(): String = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).format(this)

fun String.dateTimeFormat(): Date =
    try {
        SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).parse(this)!!
    } catch (ex: Exception) {
        Date()
    }

fun Date.dateFormat(): String = SimpleDateFormat("yyyy/MM/dd", Locale.US).format(this)