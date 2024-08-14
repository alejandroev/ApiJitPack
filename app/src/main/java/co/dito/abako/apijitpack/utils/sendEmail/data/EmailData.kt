package co.dito.abako.apijitpack.utils.sendEmail.data

import android.os.Build
import co.dito.abako.apijitpack.data.common.utils.dateTimeFormat
import co.dito.abako.apijitpack.utils.StorageUtils
import java.io.File
import java.net.URI
import java.util.Date

data class EmailData(
    val title: String,
    val body: EmailBody? = null,
    val bodyError: EmailBodyError? = null,
    val paths: List<EmailPath> = emptyList(),
    val type: EmailType,
)

data class EmailBody(
    val agencyName: String = EMPTY,
    val businessCode: String = EMPTY,
    val userName: String = EMPTY,
    val userId: Int = 0,
    val user: String = EMPTY,
    val userPassword: String = EMPTY,
    val userEmail: String = EMPTY,
    val userPhone: String = EMPTY,
    val deviceCurrentDate: Date = Date(),
    val applicationVersionName: String = EMPTY,
    val batteryPercentage: Float = 0F,
    val messageWarning: String
) {

    override fun toString(): String {
        return messageWarning + "\n\nDatos del usuario \n" +
                "Fecha: ${deviceCurrentDate.dateTimeFormat()}\n" +
                "Agencia: $agencyName\n" +
                "Negocio: $businessCode\n" +
                "Nombre Usuario: $userName\n" +
                "Id Usuario: $userId\n" +
                "Usuario: $user\n" +
                "Contraseña: $userPassword\n" +
                "Correo: $userEmail\n" +
                "Teléfono: $userPhone\n" +
                "Versión: $applicationVersionName\n\n" +
                "Datos del telefono \n" +
                "Modelo: ${Build.MANUFACTURER} - ${Build.MODEL}\n" +
                "Batería: $batteryPercentage%\n" +
                "Espacio libre: ${StorageUtils().getAvailableFreeMemory()}%\n" +
                "Android: SDK: ${Build.VERSION.SDK_INT} / Versión: ${Build.VERSION.RELEASE}"
    }
}

data class EmailBodyError(
    val url: String,
    val request: String,
    val response: String,
    val resultCode: Int,
    val timeResponse: Long
) {
    override fun toString(): String {
        return "Error backend\n\n" +
                "URL SERVICIO: $url\n" +
                "REQUEST: $request\n" +
                "RESPONSE: $response\n" +
                "ResultCode: $resultCode\n" +
                "Tiempo de respuesta: $timeResponse"
    }
}

data class EmailPath(
    val name: String,
    val file: File
)

enum class EmailType {
    SUPPORT,
    AUTOMATIC
}

private const val EMPTY = ""