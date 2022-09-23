package dev.gumato.workoutlog.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.gumato.workoutlog.models.LoginRequest
import dev.gumato.workoutlog.models.LoginResponse
import dev.gumato.workoutlog.models.RegisterRequest
import dev.gumato.workoutlog.models.RegisterResponse
import dev.gumato.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch


class UserViewModel: ViewModel(){
    val userRepository = UserRepository()
    val loginResponseLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    var registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }

        else{
            errorLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepository.makeUserRequest(registerRequest)
            if (response.isSuccessful){
               registerResponseLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }

    }

}