package co.dito.abako.apijitpack.data.common.converters

import co.dito.abako.apijitpack.data.common.utils.dateTimeFormat
import co.dito.abako.apijitpack.data.common.utils.stringToTimeOld
import com.google.gson.*
import java.lang.reflect.Type
import java.util.*

class DateTimeJsonDeserialize : JsonDeserializer<Date> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date = json?.asString?.dateTimeFormat() ?: Date()
}