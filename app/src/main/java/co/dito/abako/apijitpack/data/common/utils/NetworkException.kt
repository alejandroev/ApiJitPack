package co.dito.abako.apijitpack.data.common.utils

import java.io.IOException

open class ApiAbakoException(message: String?) : IOException(message)

open class BadRequest(message: String?) : ApiAbakoException(message)
class NotFound(message: String?) : ApiAbakoException(message)
class ServerError(message: String?) : ApiAbakoException(message)
class Unauthorized(message: String?) : ApiAbakoException(message)

class NoInternet(message: String?) : ApiAbakoException(message)
class TimeOut(message: String?) : ApiAbakoException(message)

class BackEndException(message: String?) : Exception(message)
