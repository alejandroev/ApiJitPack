package co.dito.abako.apijitpack.data.common

import com.google.gson.annotations.SerializedName

/**
 * data class for the control of responses of a list of data
 */
data class WrappedListResponse<T> (
    var code: Int,
    @SerializedName("message") var message : String,
    @SerializedName("status") var status : Boolean,
    @SerializedName("errors") var errors : List<String>? = null,
    @SerializedName("data") var data : List<T>? = null
)

/**
 * data class for the response control of a data
 */
data class WrappedResponse<T> (
    var code: Int,
    @SerializedName("message") var message : String,
    @SerializedName("status") var status : Boolean,
    @SerializedName("errors") var errors : List<String>? = null,
    @SerializedName("data") var data : T? = null
)