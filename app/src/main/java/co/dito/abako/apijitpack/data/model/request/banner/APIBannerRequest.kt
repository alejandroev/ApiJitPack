package co.dito.abako.apijitpack.data.model.request.banner

import com.google.gson.annotations.SerializedName

data class APIBannerRequest(
    @SerializedName("proceso") val process: String,
    @SerializedName("idBanner") val bannerId: Int,
    @SerializedName("descripcion") val description: String = "",
    @SerializedName("imagenClasica") val classicImage: String? = "",
    @SerializedName("imagenFull") val fullImage: String? = "",
    @SerializedName("imagenMobile") val mobileImage: String? = "",
    @SerializedName("codigoReenvio") val reSendCode: String? = "",
    @SerializedName("usuario") val user: Int = 0
)
