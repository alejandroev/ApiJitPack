package co.dito.abako.apijitpack.data.common.converters

import co.dito.abako.apijitpack.data.common.utils.convertirFechaLong
import co.dito.abako.apijitpack.data.common.utils.stringToTimeOld
import com.google.gson.*
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateJsonDeserializeOld : JsonDeserializer<Date> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date = Date(if(!json?.asString.isNullOrEmpty()) json?.asString.stringToTimeOld() else 0)
}

class DateJsonDeserializeOldApi : JsonDeserializer<Date> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date = Date((if(!json?.asString.isNullOrEmpty()) json?.asString?.convertirFechaLong() else 0)!!)
}

class DateJsonDeserialize : JsonDeserializer<Date> {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        return json?.asString?.let {
            dateFormat.parse(it)
        } ?: Date(0) // Devuelve la fecha por defecto en caso de cadena nula o vacía
    }
}