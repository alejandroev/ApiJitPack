package co.dito.abako.apijitpack.data.common.converters

import com.google.gson.JsonSerializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import java.lang.reflect.Type
import java.util.Date

class DateJsonSerializeOld : JsonSerializer<Date> {

    override fun serialize(
        src: Date,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement = JsonPrimitive("/Date(" + src.time + "+0200)/")
}