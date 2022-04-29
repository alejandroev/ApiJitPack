package co.dito.abako.apijitpack.data.model.response.invoice

import co.dito.abako.apijitpack.data.common.converters.DateJsonDeserializeOld
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param idPed = Sales order id
 * @param IdVnt = Sales id
 * @param Fctr = Sales number
 * @param fc = Invoice creation date
 * @param IdEmp = Company id
 * @param IdAssr = Advisor id
 * @param FP = Payment method id
 * @param OtrosValores = Other values
 * @param IdArt = Article id
 * @param Cant = Sales quantity
 * @param Precio = Price
 * @param Subtotal = subtotal
 */
data class InvoiceSyncResponse(
    @SerializedName("IdPed") val idPed: Int,
    @SerializedName("IdVnt") val IdVnt: Int,
    @SerializedName("Fctr") val Fctr: Int,
    @JsonAdapter(DateJsonDeserializeOld::class) @SerializedName("Fc") val fc: Date,
    @SerializedName("IdEmp") val IdEmp: Int,
    @SerializedName("IdAssr") val IdAssr: Int,
    @SerializedName("FP") val FP: Int,
    @SerializedName("OtrosValores") val OtrosValores: Int,
    @SerializedName("IdArt") val IdArt: Int,
    @SerializedName("Cant") val Cant: Int,
    @SerializedName("Precio") val Precio: Int,
    @SerializedName("Subtotal") val Subtotal: Int
)