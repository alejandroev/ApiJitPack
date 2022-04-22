package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

/**
 * @Deprecated Solo usar para los servicios viejos, luego de que se migren a API Deprecar y posterior eliminar clases
 * @param msgId = Id of message
 * @param msgStr = Message
 */
open class MessageResponseOld(
    @SerializedName("MsgId") open val msgId: Int = 0,
    @SerializedName("MsgStr") open val msgStr: String = ""
)
