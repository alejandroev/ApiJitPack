package co.dito.abako.apijitpack.data.repository

import co.dito.abako.apijitpack.data.common.utils.ApiAbakoException
import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.firebase.LoginBusinessResponse
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import co.dito.abako.apijitpack.data.network.FirebaseApiService
import co.dito.abako.apijitpack.domain.firebase.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseRepositoryImp @Inject constructor(
    private val firebaseApiService: FirebaseApiService
) : FirebaseRepository {

    override suspend fun getSupportResponse(supportRequest: SupportRequest): Flow<SupportResponse> {
        return flow {
            firebaseApiService.supportCodi(supportRequest).let {
                val response = SupportResponse(message = it.message)
                emit(response)
            }
        }
    }

    override suspend fun loginBusiness(loginBusinessRequest: LoginBusinessRequest): Flow<LoginBusinessResponse> = flow {
        val loginResponse = firebaseApiService.loginBusiness(loginBusinessRequest)
        if (!loginResponse.error.isNullOrEmpty()) {
            throw ApiAbakoException(loginResponse.error)
        }
        if (!loginResponse.state) {
            throw ApiAbakoException(loginResponse.reasonInactive)
        }
        val configurationsApiResponse = loginResponse.configurationsApiResponse.filter { it.code == CODE_HTTPS }
        if (configurationsApiResponse.isEmpty()) {
            throw ApiAbakoException(URL_HTTPS_NOT_FOUND)
        }
        emit(loginResponse.copy(configurationsApiResponse = configurationsApiResponse))
    }
}

private const val CODE_HTTPS = "URLS"
private const val URL_HTTPS_NOT_FOUND = "URL HTTPS no encontrada"