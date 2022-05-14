package co.dito.abako.apijitpack.data.repository.utils

interface ErrorProcessor {

    fun handlerError(error: Throwable) : String
}