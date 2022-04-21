package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class OrderEdit(
    @SerializedName("idPed") val idOrder: Int,
    @SerializedName("idEmp") val idEmployee: Int,
    @SerializedName("obs") val obs: String,
    @SerializedName("agn") val agn: String,
    @SerializedName("usr") val usr: Int,
    @SerializedName("fnt") val fnt: Int,
    @SerializedName("dll") val dll: List<DllOrder>,
    @SerializedName("dllCmb") val dllCmb: List<DllCmbOrder>
)
