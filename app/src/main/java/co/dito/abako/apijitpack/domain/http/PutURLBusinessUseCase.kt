package co.dito.abako.apijitpack.domain.http

import co.dito.abako.apijitpack.utils.ApiSharedPreference
import javax.inject.Inject

class PutURLBusinessUseCase @Inject constructor(
    private val apiSharedPreference: ApiSharedPreference
) {

    suspend operator fun invoke(url: String) = apiSharedPreference.putURLBusiness(url)
}