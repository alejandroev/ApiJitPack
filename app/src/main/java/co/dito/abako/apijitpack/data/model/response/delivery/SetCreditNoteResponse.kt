package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param states = List of states return
 * @param idDevolution = Id of devolution
 */

data class SetCreditNoteResponse(
    @SerializedName("Estado") val states: List<MessageResponseOld>,
    @SerializedName("IdDev") val idDevolution: Int,
    @SerializedName("Nota") val note: Int
) : MessageResponseOld()