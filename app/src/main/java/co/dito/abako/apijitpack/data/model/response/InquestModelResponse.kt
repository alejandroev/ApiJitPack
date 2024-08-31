package co.dito.abako.apijitpack.data.model.response

import com.google.gson.annotations.SerializedName

data class InquestModelResponse(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("mensaje") var messagesModel: MessageModel = MessageModel(),
    @SerializedName("encuestas") var encuestas: List<InquestModel> = emptyList(),
    @SerializedName("empresas") var empresas: List<InquestCompany> = emptyList(),
    @SerializedName("detalle") var detalle: List<InquestModelDell> = emptyList(),

    )

data class InquestCompany(
    @SerializedName("id") val id: Double,
    @SerializedName("idEmpresa") val idEmpresa: Double,
)

data class InquestModelDell(
    @SerializedName("id") val id: Int,
    @SerializedName("etiqueta") val etiqueta: String = "",
    @SerializedName("orden") val orden: Double = 0.0,
    @SerializedName("metadato") val metadato: String = "",
    @SerializedName("fuente") val fuente: String = "",
    @SerializedName("title") var title: String? = "Foto",
    @SerializedName("obligatoria") val obligatoria: Boolean = true,
    @SerializedName("irAOrden")  var irAOrden: String? = "",
    @SerializedName("iraOpcion") var iraOpcion: String? = "",
)


data class CargarImagenesModelResponse(
    @SerializedName("urlPublica") val urlPublica: String,
    @SerializedName("urlPrivada") val urlPrivada: String,
    @SerializedName("mensaje") val mensaje: MessageModel,
)

data class MessageModel(
    @SerializedName("msgId") val msgId: Int = -2,
    @SerializedName("msgStr") val msgStr: String = "Error al cunsumir servicio",
)

data class InquestModel(
    var id: Int = 0,
    var documento: Int = 0,
    var descripcion: String = "",
    var observacion: String = "",
    var irAOrden: String? = "",
    var iraOpcion: String? = "",
    var obligatoria: Boolean = false,
)

data class ImagenesRequest(
    @SerializedName("ubicacion") val ubicacion: String = "ENC",
    @SerializedName("nombre") val nombre: String = "",
    @SerializedName("imagen") val imagen: String = "",
)
