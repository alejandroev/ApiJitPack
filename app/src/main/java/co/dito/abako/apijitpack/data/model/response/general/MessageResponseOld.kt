package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

/**
 * @Deprecated Only use for the old services, after to migrate to the new API send to Deprecated and later delete the classes
 * @param msgId = Id of message
 * @param msgStr = Message
 */
open class MessageResponseOld(
    @SerializedName("MsgId") open val msgId: Int = 0,
    @SerializedName("MsgStr") open val msgStr: String = ""
)
