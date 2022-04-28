package co.dito.abako.apijitpack.data.common.utils

import java.io.IOException

sealed class NetworkException(message: String?) : IOException(message) {

    open class BadRequest(message: String?) : NetworkException(message)
    class NotFound(message: String?) : BadRequest(message)
    class ServerError(message: String?) : NetworkException(message)
    class Unauthorized(message: String?) : NetworkException(message)

    class NoInternet(message: String?) : NetworkException(message)
    class TimeOut(message: String?) : NetworkException(message)
    class Connection(message: String?) : NetworkException(message)
}
