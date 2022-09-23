package dev.gumato.workoutlog.repository

import dev.gumato.workoutlog.api.ApiClient
import dev.gumato.workoutlog.api.ApiInterface
import dev.gumato.workoutlog.models.LoginRequest
import dev.gumato.workoutlog.models.LoginResponse
import dev.gumato.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> = withContext(
        Dispatchers.IO){
        val response = apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun makeUserRequest(registerRequest: RegisterRequest)
            = withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
}