package co.dito.abako.apijitpack.data.common.converters

import co.dito.abako.apijitpack.data.common.utils.dateFormat
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.util.Date

class DateJsonSerialize : JsonSerializer<Date> {

    override fun serialize(
        src: Date,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement = JsonPrimitive(src.dateFormat())
}