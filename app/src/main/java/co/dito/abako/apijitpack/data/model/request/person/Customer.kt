package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("idUsr") val idUsr: Int,
    @SerializedName("idZn") val idZn: Int,
    @SerializedName("idCnl") val idCnl: Int,
    @SerializedName("idSgt") val idSgt: Int,
    @SerializedName("idnt") val idNt: Int,
    @SerializedName("idTpdoc") val idTpDoc: Int,
    @SerializedName("rzScl") val rzScl: String,
    @SerializedName("nmbCmn") val nmbCmn: String,
    @SerializedName("nmbCtt") val nmbCtt: String,
    @SerializedName("aplCtt") val aplCtt: String,
    @SerializedName("mail") val mail: String,
    @SerializedName("tel") val tel: String,
    @SerializedName("idPref") val idPref: Int,
    @SerializedName("dirNum") val dirNum: String,
    @SerializedName("dirInter") val dirInter: String,
    @SerializedName("dirDet") val dirDet: String,
    @SerializedName("dirIdBarr") val dirIdBarr: Int,
    @SerializedName("fc") val fc: String,
    @SerializedName("lon") val lon: Int,
    @SerializedName("lat") val lat: Int,
    @SerializedName("rfv") val rfv: String,
    @SerializedName("rut") val rut: List<Rut>
)
