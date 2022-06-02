package co.dito.abako.apijitpack.data.common.utils

import java.io.IOException

open class BadRequest(message: String?) : IOException(message)
class NotFound(message: String?) : BadRequest(message)
class ServerError(message: String?) : IOException(message)
class Unauthorized(message: String?) : IOException(message)

class NoInternet(message: String?) : IOException(message)
class TimeOut(message: String?) : IOException(message)
class Connection(message: String?) : IOException(message)
