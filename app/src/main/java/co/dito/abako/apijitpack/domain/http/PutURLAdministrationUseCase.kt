package co.dito.abako.apijitpack.domain.http

import co.dito.abako.apijitpack.utils.ApiSharedPreference
import javax.inject.Inject

class PutURLAdministrationUseCase @Inject constructor(
    private val apiSharedPreference: ApiSharedPreference
) {

    suspend operator fun invoke(url: String) = apiSharedPreference.putURLAdministration(url)
}