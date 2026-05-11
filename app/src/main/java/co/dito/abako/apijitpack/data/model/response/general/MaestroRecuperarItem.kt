package co.dito.abako.apijitpack.data.model.response.general

import com.google.gson.annotations.SerializedName

data class MaestroRecuperarItem(
    @SerializedName("id") val id: Long = 0L,
    @SerializedName("descripcion") val descripcion: String = "",
    @SerializedName("codigo") val codigo: String? = null,
) {
    override fun toString(): String = descripcion
}
