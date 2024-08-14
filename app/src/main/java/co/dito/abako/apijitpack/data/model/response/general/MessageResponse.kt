package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

/**
 * @param msgId = Id of message
 * @param msgStr = Message
 */

open class MessageResponse(
    @SerializedName("msgId") open var msgId: Int = 0,
    @SerializedName("msgStr") open var msgStr: String = "",
)
