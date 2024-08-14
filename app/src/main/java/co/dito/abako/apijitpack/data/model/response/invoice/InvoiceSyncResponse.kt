package co.dito.abako.apijitpack.data.model.response.invoice

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param idPed = Sales order id
 * @param idVnt = Sales id
 * @param fctr = Sales number
 * @param fc = Invoice creation date
 * @param idEmp = Company id
 * @param idAssr = Advisor id
 * @param fp = Payment method id
 * @param otrosValores = Other values
 * @param idArt = Article id
 * @param cant = Sales quantity
 * @param price = Price
 * @param subtotal = subtotal
 */
data class InvoiceSyncResponse(
    @SerializedName("idPed") val idPed: Int,
    @SerializedName("idVnt") val idVnt: Int,
    @SerializedName("fctr") val fctr: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("fc") val fc: Date,
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("idAssr") val idAssr: Int,
    @SerializedName("fp") val fp: Int,
    @SerializedName("otrosValores") val otrosValores: Double,
    @SerializedName("idArt") val idArt: Int,
    @SerializedName("cant") val cant: Double,
    @SerializedName("precio") val price: Double,
    @SerializedName("subtotal") val subtotal: Double,
    @SerializedName("orden") val orden: Double,
)