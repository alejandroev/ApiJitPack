package co.dito.abako.apijitpack.data.repository.utils

import co.dito.abako.apijitpack.data.common.utils.BackEndException
import co.dito.abako.apijitpack.data.common.utils.BadRequest
import co.dito.abako.apijitpack.data.common.utils.NoInternet
import co.dito.abako.apijitpack.data.common.utils.NotFound
import co.dito.abako.apijitpack.data.common.utils.ServerError
import co.dito.abako.apijitpack.data.common.utils.TimeOut
import co.dito.abako.apijitpack.data.common.utils.Unauthorized
import co.dito.abako.apijitpack.domain.NO_INTERNET_CONNECTION
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException

class ErrorProcessorImp : ErrorProcessor {

    override fun handlerError(error: Throwable): String {
        return when (error) {
            is SocketTimeoutException,
            is TimeOut,
            is ConnectException,
            is NoInternet,
            is UnknownHostException,
            is UnknownServiceException,
            -> {
                if (NO_INTERNET_CONNECTION == error.message) {
                    WHOOPS_LOST_INTERNET_CONNECTION
                } else {
                    CONNECTIVITY_ERROR
                }
            }
            is ServerError,
            is BadRequest,
            is NotFound,
            -> CONNECTIVITY_ERROR
            is Unauthorized -> EXPIRED_CONNECTION
            is BackEndException -> BACKEND_ERROR
            else -> UNKNOWN_ERROR
        }
    }
}

private const val WHOOPS_LOST_INTERNET_CONNECTION = "Su conexión a Internet ha sido interrumpida." +
        "\nVerifique su configuración de Internet."

private const val CONNECTIVITY_ERROR = "No pudimos contactar correctamente con el servidor." +
        "\nPor favor, inténtelo de nuevo más tarde."

private const val EXPIRED_CONNECTION = "Conexión expiró." +
        "\nPor favor salir e ingresar nuevamente a la App."

private const val UNKNOWN_ERROR = "La aplicación experimentó un error. " +
        "\nPor favor, inténtelo de nuevo más tarde. " +
        "\nSi el problema persiste, póngase en contacto con el soporte."

private const val BACKEND_ERROR = "La aplicación se conecto al servicio." +
        "\nSin embargo se produjo un error al momento de obtener la respuesta." +
        "\nEl equipo de soporte ya esta validando y se comunicarán con usted en el menor tiempo posible."