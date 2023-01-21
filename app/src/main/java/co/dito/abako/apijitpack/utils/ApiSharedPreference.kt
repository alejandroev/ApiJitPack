package co.dito.abako.apijitpack.utils

import android.content.SharedPreferences
import co.dito.abako.apijitpack.API_BUSINESS
import co.dito.abako.apijitpack.API_MOBILE
import co.dito.abako.apijitpack.API_SHARE_PREFERENCES
import javax.inject.Inject
import javax.inject.Named

class ApiSharedPreference @Inject constructor(
    @Named(API_SHARE_PREFERENCES) private val sharePreference: SharedPreferences
) {

    fun putURLMobile(url: String) = sharePreference.edit().putString(KEY_URL_MOBILE, url).apply()
    fun getURLMobile(): String = sharePreference.getString(KEY_URL_MOBILE, FAKE_URL_BASE_MOBILE) ?: FAKE_URL_BASE_MOBILE

    fun putURLBusiness(url: String) = sharePreference.edit().putString(KEY_URL_BUSINESS, url).apply()
    fun getURLBusiness(): String = sharePreference.getString(KEY_URL_BUSINESS, FAKE_URL_BASE_BUSINESS) ?: FAKE_URL_BASE_BUSINESS

    fun putCodeCODI(code: String) = sharePreference.edit().putString(KEY_CODI_CODE, code).apply()
    fun getCodeCODI(): String = sharePreference.getString(KEY_CODI_CODE, "") ?: ""
}

private const val KEY_CODI_CODE = "CODI_CODE"
private const val KEY_URL_MOBILE = "URL_MOBILE"
private const val KEY_URL_BUSINESS = "URL_BUSINESS"

private const val FAKE_URL_BASE_MOBILE = "https://www.google.com/$API_MOBILE"
private const val FAKE_URL_BASE_BUSINESS = "https://www.google.com/$API_BUSINESS"