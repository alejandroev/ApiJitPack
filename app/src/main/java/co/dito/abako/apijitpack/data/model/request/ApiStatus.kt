package co.dito.abako.apijitpack.data.model.request

data class ApiStatus(
    var code: Int = 0,
    var error: String = "",
    var success: Boolean = false,
    var method: String = "",
    var body: String = "",
    var url: String = "",
    var service: String = "",
)
