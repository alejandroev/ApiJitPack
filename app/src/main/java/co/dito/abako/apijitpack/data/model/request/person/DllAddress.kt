package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class DllAddress(
    @SerializedName("idDireccion") val idAddress: Int,
    @SerializedName("idTipoDireccion") val idAddressType: Int,
    @SerializedName("idBarrio") val idTown: Int,
    @SerializedName("idEstrato") val idStratum: Int,
    @SerializedName("idPrefijoDireccionUno") val idAddressPrefix: Int,
    @SerializedName("parteUno") val partOne: String,
    @SerializedName("parteDos") val partTwo: String,
    @SerializedName("parteTres") val partThree: String,
    @SerializedName("predeterminado") val default: Int,
    @SerializedName("codigoPostal") val postalCode: String,
    @SerializedName("operacion") val operation: String,
    @SerializedName("barrio") val town: String,
    @SerializedName("ciudad") val city: String,
    @SerializedName("departamento") val department: String,
    @SerializedName("pais") val country: String,
    @SerializedName("direccion") val address: String
)