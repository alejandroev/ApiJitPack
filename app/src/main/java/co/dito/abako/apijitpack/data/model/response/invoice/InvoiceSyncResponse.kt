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
    @SerializedName("IdPed") val idPed: Int,
    @SerializedName("IdVnt") val idVnt: Int,
    @SerializedName("Fctr") val fctr: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("Fc") val fc: Date,
    @SerializedName("IdEmp") val idEmp: Int,
    @SerializedName("IdAssr") val idAssr: Int,
    @SerializedName("FP") val fp: Int,
    @SerializedName("OtrosValores") val otrosValores: Double,
    @SerializedName("IdArt") val idArt: Int,
    @SerializedName("Cant") val cant: Double,
    @SerializedName("Precio") val price: Double,
    @SerializedName("Subtotal") val subtotal: Double
)