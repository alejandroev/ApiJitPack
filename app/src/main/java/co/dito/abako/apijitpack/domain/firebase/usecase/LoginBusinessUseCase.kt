package co.dito.abako.apijitpack.domain.firebase.usecase

import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.response.firebase.LoginBusinessResponse
import co.dito.abako.apijitpack.domain.firebase.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginBusinessUseCase @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) {

    suspend operator fun invoke(loginBusinessRequest: LoginBusinessRequest) : Flow<LoginBusinessResponse> =
        firebaseRepository.loginBusiness(loginBusinessRequest)
}