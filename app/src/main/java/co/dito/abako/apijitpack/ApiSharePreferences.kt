package co.dito.abako.apijitpack

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named

class ApiSharePreferences @Inject constructor(
    @Named(API_SHARE_PREFERENCES) private val sharedPreference: SharedPreferences
) {

    fun putURL(url: String) = sharedPreference.edit().putString(KEY_URL, url).apply()
    fun getURL(): String = sharedPreference.getString(KEY_URL, "") ?: ""
}
private const val KEY_URL = "URL"