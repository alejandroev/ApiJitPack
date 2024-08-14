package co.dito.abako.apijitpack.data.common.converters

import co.dito.abako.apijitpack.data.common.utils.dateTimeFormat
import co.dito.abako.apijitpack.data.common.utils.stringToTimeOld
import com.google.gson.*
import java.lang.reflect.Type
import java.util.*

class DateTimeJsonDeserializeWompi : JsonDeserializer<Date> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        return json?.asString?.dateTimeFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") ?: Date()
    }
}