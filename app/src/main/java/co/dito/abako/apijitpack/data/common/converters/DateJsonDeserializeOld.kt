package co.dito.abako.apijitpack.data.common.converters

import co.dito.abako.apijitpack.data.common.utils.convertirFechaLong
import co.dito.abako.apijitpack.data.common.utils.stringToTimeOld
import com.google.gson.*
import java.lang.reflect.Type
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