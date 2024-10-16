package co.dito.abako.apijitpack.data.model.request.delivery

import co.dito.abako.abako.abako.data.model.DllItemCredit
import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonSerialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * @param idSale = Id of sales
 * @param idOrder = Id of order
 * @param idReasonReturn = Id of reason return
 * @param observation = Observation
 * @param creationDate = Creation date
 * @param idUser = Id of user
 * @param longitude = Longitude
 * @param latitude = Latitude
 * @param validationReference = Validation reference
 * @param dlls = List of articles to return
 */

data class SetCreditNoteRequest(
    @SerializedName("IdVnt") val idSale: Int,
    @SerializedName("IdPed") val idOrder: Int,
    @SerializedName("IdMot") val idReasonReturn: Int,
    @SerializedName("Obs") val observation: String,
    @JsonAdapter(DateTimeJsonSerialize::class) @SerializedName("Fc") val creationDate: Date,
    @SerializedName("Usr") val idUser: Int,
    @SerializedName("Lon") val longitude: Double,
    @SerializedName("Lat") val latitude: Double,
    @SerializedName("Rfv") val validationReference: String,
    @SerializedName("Dll") val dlls: List<SetCreditNoteDetailRequest>,
)

fun SetCreditNoteRequest.toCreditNoteRequest(): CreditNoteRequest {
    return CreditNoteRequest(
        key = "",
        idVnt = this.idSale,
        idPed = this.idOrder,
        idMot = this.idReasonReturn,
        obs = this.observation,
        fc = this.creationDate,
        usr = this.idUser,
        lon = this.longitude,
        lat = this.latitude,
        rfv = this.validationReference,
        dll = this.dlls.map { it.toDllItemCredit() }
    )
}

fun SetCreditNoteDetailRequest.toDllItemCredit(): DllItemCredit {
    return DllItemCredit(
        idArt = this.idArticle,
        cant = this.quantity.toInt(),
        prcs = this.prcs
    )
}
