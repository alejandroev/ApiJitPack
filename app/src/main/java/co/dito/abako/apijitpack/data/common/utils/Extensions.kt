package co.dito.abako.apijitpack.data.common.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String?.stringToTimeOld(): Long {
    return this?.replace("/", "")?.replace("Date(", "")?.replace(")", "")?.toLong() ?: 0
}

fun String.convertirFechaLong(): Long {
    val formato = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
    formato.timeZone = TimeZone.getTimeZone("UTC")

    return try {
        val fecha = formato.parse(this)
        fecha.time
    } catch (e: Exception) {
       0
    }
}


fun String.toDateOrNow(): Date {
    return try {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        dateFormat.parse(this) ?: Date() // Si la conversión falla, devolver la fecha y hora actual
    } catch (e: java.text.ParseException) {
        Date() // En caso de error, devolver la fecha y hora actual
    }
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