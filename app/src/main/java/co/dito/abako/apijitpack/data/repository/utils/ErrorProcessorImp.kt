package co.dito.abako.apijitpack.data.repository.utils

import co.dito.abako.apijitpack.data.common.utils.BadRequest
import co.dito.abako.apijitpack.data.common.utils.NoInternet
import co.dito.abako.apijitpack.data.common.utils.ServerError
import co.dito.abako.apijitpack.data.common.utils.TimeOut
import co.dito.abako.apijitpack.data.common.utils.Unauthorized
import co.dito.abako.apijitpack.domain.NO_INTERNET_CONNECTION
import java.net.ConnectException
import java.net.SocketTimeoutException

class ErrorProcessorImp : ErrorProcessor {

    override fun handlerError(error: Throwable): String {
        return when (error) {
            is SocketTimeoutException,
            is TimeOut,
            is ConnectException,
            is NoInternet,
            -> {
                if (NO_INTERNET_CONNECTION == error.message) {
                    WHOOPS_LOST_INTERNET_CONNECTION
                } else {
                    CONNECTIVITY_ERROR
                }
            }
            is ServerError,
            is BadRequest,
            -> CONNECTIVITY_ERROR

            is Unauthorized -> {
                EXPIRED_CONNECTION
            }

            else -> UNKNOWN_ERROR
        }
    }
}

const val WHOOPS_LOST_INTERNET_CONNECTION =
    "Su conexión a Internet ha sido interrumpida.\nVerifique su configuración de Internet."

const val CONNECTIVITY_ERROR =
    "No pudimos contactar correctamente con el servidor. \nPor favor, inténtelo de nuevo más tarde."

const val EXPIRED_CONNECTION = "Conexión expiró.\nPor favor salir e ingresar nuevamente a la App."

const val UNKNOWN_ERROR =
    "La aplicación experimentó un error. Por favor, inténtelo de nuevo más tarde. Si el problema persiste, póngase en contacto con el soporte."