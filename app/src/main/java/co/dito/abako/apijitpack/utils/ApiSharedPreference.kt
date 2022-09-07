package co.dito.abako.apijitpack.utils

import android.content.SharedPreferences
import co.dito.abako.apijitpack.API_SHARE_PREFERENCES
import javax.inject.Inject
import javax.inject.Named

class ApiSharedPreference @Inject constructor(
    @Named(API_SHARE_PREFERENCES) private val sharePreference: SharedPreferences
) {

    fun putCodeCODI(code: String) = sharePreference.edit().putString(KEY_CODI_CODE, code).apply()
    fun getCodeCODI(): String = sharePreference.getString(KEY_CODI_CODE, "") ?: ""
}

private const val KEY_CODI_CODE = "CODI_CODE"