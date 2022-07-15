package co.dito.abako.apijitpack.data.network

import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.model.response.general.MessageResponse
import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import co.dito.abako.apijitpack.domain.ERROR_MESSAGE_ID

fun MessageResponseOld.validResponse() {
    if (this.msgId == ERROR_MESSAGE_ID) {
        throw BackEndException(this.msgStr)
    }
}

fun MessageResponse.validResponse() {
    if (this.msgId == ERROR_MESSAGE_ID) {
        throw BackEndException(this.msgStr)
    }
}