package com.example.kitepkana.data.remote.utils

import com.example.kitepkana.data.local.AppPrefs
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    val appPrefs: AppPrefs,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = appPrefs.jwtAccess
        val request = chain.request()
        if (!token.isNullOrEmpty()) {
            val newRequest = request
                .newBuilder()
                .header("Authorization", "JWT $token")
                .build()
            val response = chain.proceed(newRequest)
             if (response.code == 401) {
                 //gg
            } else {
                return response
            }
        }
        return chain.proceed(request)
    }
}
