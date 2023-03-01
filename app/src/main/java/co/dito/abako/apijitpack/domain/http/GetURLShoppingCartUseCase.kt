package co.dito.abako.apijitpack.domain.http

import co.dito.abako.apijitpack.utils.ApiSharedPreference
import javax.inject.Inject

class GetURLShoppingCartUseCase @Inject constructor(
    private val apiSharedPreference: ApiSharedPreference
) {

    operator fun invoke() : String = apiSharedPreference.getURLShoppingCart()
}