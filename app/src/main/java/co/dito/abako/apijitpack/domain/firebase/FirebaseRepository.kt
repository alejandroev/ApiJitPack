package co.dito.abako.apijitpack.domain.firebase

import co.dito.abako.apijitpack.data.model.request.firebase.LoginBusinessRequest
import co.dito.abako.apijitpack.data.model.request.support.SupportRequest
import co.dito.abako.apijitpack.data.model.response.firebase.LoginBusinessResponse
import co.dito.abako.apijitpack.data.model.response.support.SupportResponse
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {

    suspend fun getSupportResponse(supportRequest: SupportRequest) : Flow<SupportResponse>

    suspend fun loginBusiness(loginBusinessRequest: LoginBusinessRequest) : Flow<LoginBusinessResponse>
}