package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param states = List of states return
 * @param idDev = Id of devolution
 * @param msgId = Id of message service
 * @param msgStr = Message of service
 */

data class SetCreditNoteResponse(
    @SerializedName("Estado") val states: List<MessageResponseOld>,
    @SerializedName("IdDev") val idDev: Int,
    @SerializedName("MsgId") val msgId: Int,
    @SerializedName("MsgSrt") val msgStr: String?,
)