package co.dito.abako.apijitpack.utils

import android.util.Patterns
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import java.util.regex.Pattern

fun String.validateEmail(): Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.validateNumber(): Boolean =
    Pattern.compile("(3)[ -]*([0-9][ -]*){9}").matcher(this).matches() ||
            Pattern.compile("(60)[ -]*([0-9][ -]*){8}").matcher(this).matches()

fun <T> Response<ResponseBody?>.extractArray(target: Class<T>, key: String): T? {
    val string = this.body()?.string()
    if (string.isNullOrEmpty()) {
        throw Exception("Transaction Validation not found")
    }

    val responseObject = string.ifEmpty {
        "{}"
    }.let {
        JSONObject(it)
    }
    return Gson().fromJson(responseObject.getString(key), target)
}