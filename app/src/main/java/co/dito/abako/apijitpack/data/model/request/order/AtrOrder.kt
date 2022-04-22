package co.dito.abako.apijitpack.data.model.request.order

import com.google.gson.annotations.SerializedName

data class AtrOrder(
    @SerializedName("idEmpSuc") val idEmpSuc: Int,
    @SerializedName("cant") val cant: Int
)
