package com.example.kitepkana.data.remote.service

import com.example.kitepkana.data.model.JWTAccessResponse
import com.example.kitepkana.data.model.JWTRefreshModel
import com.example.kitepkana.data.model.authorization.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationService {

    @POST("auth/users/")
    suspend fun registerUsers(
        @Body registerUsersModel: RegisterUsersModel
    ): RegisterUsersResponse

    @POST("auth/users/activation/")
    suspend fun activationAccount(
        @Body activationAccountModel: ActivationAccountModel
    ): ActivationAccountResponse

    @POST("auth/users/resend_activation/")
    suspend fun resendActivationAccount(
        @Body resendActivationAccountModel: ResendActivationAccountModel
    ): ResendActivationAccountModel

    @POST("auth/jwt/create/")
    suspend fun createJwtToken(
        @Body createJwtTokenModel: CreateJwtTokenModel
    ): JwtTokenResponse

    @POST("auth/jwt/refresh/")
    suspend fun refreshJWT(
        @Body jwtRefreshModel: JWTRefreshModel
    ): Response<JWTAccessResponse>
}