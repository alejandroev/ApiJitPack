package co.dito.abako.apijitpack.data.common.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String?.stringToTimeOld(): Long {
    return this?.replace("/", "")?.replace("Date(", "")?.replace(")", "")?.toLong() ?: 0
}

fun Date.dateTimeFormat(): String = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).format(this)

fun String.dateTimeFormat(format: String = "yyyy/MM/dd HH:mm"): Date =
    try {
        SimpleDateFormat(format, Locale.US).parse(this.trim())!!
    } catch (ex: Exception) {
        Date()
    }

fun Date.dateFormat(format: String = CURRENT_DATE_FORMAT): String {
    val newFormat = SimpleDateFormat(format, Locale.US).format(this)
  return  newFormat
}

private const val CURRENT_DATE_FORMAT = "yyyy/MM/dd"
const val REQUEST_DATE_FORMAT = "yyyy-MM-dd"