package co.dito.abako.apijitpack.data.common.utils

data class NetworkErrorContent(
    val statusCode: String,
    val error: String,
    val message: String?
)