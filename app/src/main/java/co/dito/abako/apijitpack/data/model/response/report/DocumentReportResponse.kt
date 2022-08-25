package co.dito.abako.apijitpack.data.model.response.report

import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.annotations.SerializedName

data class DocumentReportResponse(
    @SerializedName("encabezado") val header: String,
    @SerializedName("detalle") val detail: String
) : MessageResponse()


fun <T> String.mapper(clazz: Class<T>) : T {
    val xmlMapper = XmlMapper(JacksonXmlModule().apply { setDefaultUseWrapper(false) })
    xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    return xmlMapper.readValue(this, clazz)
}
