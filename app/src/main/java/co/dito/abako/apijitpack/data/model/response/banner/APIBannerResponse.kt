package co.dito.abako.apijitpack.data.model.response.banner

import co.dito.abako.apijitpack.data.common.converters.DateTimeJsonDeserialize
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Created by hans fritz on 12/04/17.
 */
data class APIBannerResponse(
    @SerializedName("idBanner") val bannerId: Int,
    @SerializedName("titulo") val title: String,
    @SerializedName("descripcion") val description: String,
    @SerializedName("imagenClasica") val classicImage: String?,
    @SerializedName("imagenFull") val fullImage: String?,
    @SerializedName("imagenMobile") val mobileImage: String?,
    @SerializedName("codigoReenvio") val reSendCode: String?,
    @JsonAdapter(DateTimeJsonDeserialize::class) @SerializedName("fechaModificacion") val lastUpdate: Date,
    @SerializedName("modificador") val modifier: String
)