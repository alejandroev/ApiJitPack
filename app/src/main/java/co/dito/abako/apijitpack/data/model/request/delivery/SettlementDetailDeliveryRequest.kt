package co.dito.abako.apijitpack.data.model.request.delivery

import com.google.gson.annotations.SerializedName

data class SettlementDetailDeliveryRequest(
    @SerializedName("idTv") val idValueType: Int,
    @SerializedName("vc") val valueQuantity: Int,
    @SerializedName("idCri") val idCri: Long? = null,
    @SerializedName("idBnc") val idBnc: Long? = null,
    /** Texto del maestro (evita que el ERP muestre solo el id en columnas como «Cuenta»). */
    @SerializedName("desCri") val descripcionCriterio: String? = null,
    @SerializedName("desBnc") val descripcionBanco: String? = null,
    /** Código del maestro BANCOS, si aplica (p. ej. número de cuenta contable). */
    @SerializedName("cdBnc") val codigoBanco: String? = null,
)
