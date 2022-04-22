package co.dito.abako.apijitpack.data.model.request.person

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("idPersona") val idPerson: Int,
    @SerializedName("nombres") val names: String,
    @SerializedName("apellidos") val lastNames: String,
    @SerializedName("idTipoDocumento") val idDocumentType: Int,
    @SerializedName("identificacion") val identification: Int,
    @SerializedName("dllUsuario") val dllUser: List<DllUser>,
    @SerializedName("dllDireccion") val dllAddress: List<DllAddress>,
    @SerializedName("dllTelefono") val dllPhone: List<DllPhone>,
    @SerializedName("dllMail") val dllMail: List<DllMail>,
    @SerializedName("empresaUsuario") val userCompany: List<UserCompany>,
    @SerializedName("estado") val state: List<State>
)
