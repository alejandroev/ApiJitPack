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
    @SerializedName("IdCnto") val idCnto: Int,
    @SerializedName("IdEmp") val idEmp: Int,
    @SerializedName("Nmbr") val nmbr: String,
    @SerializedName("Dir") val dir: String,
    @SerializedName("IdCdd") val idCdd: Int,
    @SerializedName("IdDir") val idDir: Int,
    @SerializedName("Tel") val tel: String,
    @SerializedName("mail") val mail: String,
    @SerializedName("Pdt") val pdt: Int,
    @SerializedName("Tipo") val type: String,
    @SerializedName("Prcs") val prcs: String,
)
