package co.dito.abako.apijitpack.data.model.response.delivery

import co.dito.abako.apijitpack.data.model.response.general.MessageResponseOld
import com.google.gson.annotations.SerializedName

/**
 * @param settlementTypes = type of liquidation received
 * @param otherCharges = other expenses not estimated
 */

data class MasterDeliveryResponse(
    @SerializedName("TipoLiquidacion") val settlementTypes: List<SettlementTypeSyncResponse>,
    @SerializedName("OtrosCobros") val otherCharges: List<OtherChargesSyncResponse>,
) : MessageResponseOld()
