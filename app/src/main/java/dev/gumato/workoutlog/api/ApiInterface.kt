package dev.gumato.workoutlog.api


import dev.gumato.workoutlog.models.LoginRequest
import dev.gumato.workoutlog.models.LoginResponse
import dev.gumato.workoutlog.models.RegisterRequest
import dev.gumato.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>
}