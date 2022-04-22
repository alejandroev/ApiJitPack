package co.dito.abako.apijitpack.domain

sealed class BaseResult<out T : Any?, out U : Any?> {

    class Success<out T : Any?>(val data: T) : BaseResult<T, Nothing>()

    class Error<out U : Any?>(val rawResponse: U) : BaseResult<Nothing, U>()
}