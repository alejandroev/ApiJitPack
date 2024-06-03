package co.dito.abako.apijitpack.data.model.response.contact

import com.google.gson.annotations.SerializedName

/**
 * @param idCnto = ID of contact
 * @param idEmp = ID of client
 * @param nmbr = Contact first and last name
 * @param dir = Address of contact
 * @param idCdd = ID City of contact
 * @param idDir = ID Address of contact
 * @param tel = Telephone of contact
 * @param mail = Email of contact
 * @param pdt = Predetermined
 * @param type = Type of contact
 * @param prcs = Process
 */

data class ContactSyncResponse(
    @SerializedName("idCnto") val idCnto: Int,
    @SerializedName("idEmp") val idEmp: Int,
    @SerializedName("nmbr") val nmbr: String,
    @SerializedName("dir") val dir: String,
    @SerializedName("idCdd") val idCdd: Int,
    @SerializedName("idDir") val idDir: Int,
    @SerializedName("tel") val tel: String,
    @SerializedName("mail") val mail: String,
    @SerializedName("pdt") val pdt: Int,
    @SerializedName("tipo") val type: String,
    @SerializedName("prcs") val prcs: String,
)
